// PawPalace Custom Vanilla JavaScript

document.addEventListener("DOMContentLoaded", () => {
    initThemeToggle();
    initCartSystem();
    
    // Only init products if we are on the products page
    if (document.getElementById('product-list-container')) {
        initProductRenderer();
    }
});

// ==========================================
// 1. Theme Toggle & LocalStorage Management
// ==========================================
function initThemeToggle() {
    const themeToggleBtn = document.getElementById('theme-toggle');
    if (!themeToggleBtn) return;

    // Check saved theme
    const savedTheme = localStorage.getItem('pawpalace-theme') || 'light';
    document.documentElement.setAttribute('data-theme', savedTheme);
    updateThemeButtonUI(themeToggleBtn, savedTheme);

    themeToggleBtn.addEventListener('click', () => {
        const currentTheme = document.documentElement.getAttribute('data-theme');
        const newTheme = currentTheme === 'dark' ? 'light' : 'dark';
        
        document.documentElement.setAttribute('data-theme', newTheme);
        localStorage.setItem('pawpalace-theme', newTheme);
        updateThemeButtonUI(themeToggleBtn, newTheme);
    });
}

function updateThemeButtonUI(btn, theme) {
    if (theme === 'dark') {
        btn.innerHTML = '☀️ Light';
        btn.classList.replace('btn-outline-dark', 'btn-outline-light');
    } else {
        btn.innerHTML = '🌙 Dark';
        btn.classList.replace('btn-outline-light', 'btn-outline-dark');
    }
}

// ==========================================
// 2. Toast Notification System
// ==========================================
function showToast(message, type = 'success') {
    const container = document.getElementById('toast-container');
    if (!container) return;

    const toast = document.createElement('div');
    toast.className = `custom-toast ${type}`;
    
    const icon = type === 'success' ? '✅' : '❌';
    toast.innerHTML = `<span>${icon}</span> <span>${message}</span>`;
    
    container.appendChild(toast);

    // Trigger animation
    setTimeout(() => toast.classList.add('show'), 10);

    // Remove after 3 seconds
    setTimeout(() => {
        toast.classList.remove('show');
        setTimeout(() => toast.remove(), 300);
    }, 3000);
}

// ==========================================
// 3. Asynchronous Cart Management
// ==========================================
function initCartSystem() {
    // We attach event delegation to handle dynamically rendered Add to Cart forms
    document.body.addEventListener('submit', async (e) => {
        if (e.target.matches('.ajax-cart-form')) {
            e.preventDefault(); // Stop normal form submission

            const form = e.target;
            const productId = form.querySelector('input[name="productId"]').value;
            const quantity = form.querySelector('input[name="quantity"]').value;

            try {
                const response = await fetch('/api/cart/add', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        productId: parseInt(productId),
                        quantity: parseInt(quantity)
                    })
                });

                const data = await response.json();

                if (response.ok) {
                    showToast(data.message, 'success');
                } else if (response.status === 401) {
                    // Unauthorized
                    window.location.href = '/login';
                } else {
                    showToast(data.error || 'Failed to add item', 'error');
                }
            } catch (error) {
                console.error('Cart Error:', error);
                showToast('A network error occurred.', 'error');
            }
        }
    });
}

// ==========================================
// 4. Dynamic Product Rendering (Fetch API)
// ==========================================
let allProducts = [];

async function initProductRenderer() {
    const container = document.getElementById('product-list-container');
    const searchInput = document.getElementById('product-search-input');

    try {
        // Fetch products from the REST API
        const response = await fetch('/api/products');
        allProducts = await response.json();
        
        renderProducts(allProducts);

        // Live Search Filtering
        searchInput.addEventListener('input', (e) => {
            const query = e.target.value.toLowerCase();
            const filtered = allProducts.filter(p => 
                p.name.toLowerCase().includes(query) || 
                p.description.toLowerCase().includes(query)
            );
            renderProducts(filtered);
        });

    } catch (error) {
        container.innerHTML = `<div class="col-12 text-center text-danger py-5">
            <h4>Failed to load products. Please check your connection.</h4>
        </div>`;
    }
}

function renderProducts(products) {
    const container = document.getElementById('product-list-container');
    container.innerHTML = ''; // Clear loading spinner or old products

    if (products.length === 0) {
        container.innerHTML = `
            <div class="col-12 text-center py-5">
                <h3 class="text-muted mb-4">No products found matching your search.</h3>
            </div>`;
        return;
    }

    products.forEach(product => {
        // Create product card dynamically
        const col = document.createElement('div');
        col.className = 'col-md-4 mb-5';
        
        col.innerHTML = `
            <div class="card product-card h-100">
                <img src="${product.imageUrl}" class="card-img-top" alt="${product.name}">
                <div class="card-body d-flex flex-column">
                    <h5 class="card-title fw-bold">${product.name}</h5>
                    <p class="card-text text-muted flex-grow-1">${product.description}</p>
                    <h4 class="text-primary fw-bold mb-3">Rs. ${product.price.toFixed(2)}</h4>
                </div>
                <div class="card-footer bg-transparent border-top-0 pb-3">
                    <form class="ajax-cart-form">
                        <input type="hidden" name="productId" value="${product.id}" />
                        <div class="input-group mb-3">
                            <span class="input-group-text bg-light border-end-0">Qty</span>
                            <input type="number" name="quantity" class="form-control border-start-0" value="1" min="1" max="10">
                        </div>
                        <button type="submit" class="btn btn-outline-primary w-100 rounded-pill fw-bold">Add to Cart 🛒</button>
                    </form>
                </div>
            </div>
        `;
        container.appendChild(col);
    });
}
