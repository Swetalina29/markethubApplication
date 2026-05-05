import React from 'react';

function ProductCard({ product, onAddToCart }) {
  const formatPrice = (price) =>
    new Intl.NumberFormat('en-IN', { style: 'currency', currency: 'INR', maximumFractionDigits: 0 }).format(price);

  const isOutOfStock = product.stock === 0;
  const stockText = product.stock === 0 ? 'Out of Stock'
    : product.stock < 5 ? `Only ${product.stock} left!`
    : `${product.stock} in stock`;

  return (
    <div className="product-card">
	<img
	  src={product.imageUrl || 'https://images.unsplash.com/photo-1560393464-5c69a73c5770?w=400'}
	  alt={product.name}
	  onError={function(e) {
	    e.target.src = 'https://images.unsplash.com/photo-1560393464-5c69a73c5770?w=400';
	  }}
	/>
      <div className="product-info">
        <span className="product-category">{product.category?.replace('_', ' ')}</span>
        <h3 className="product-name">{product.name}</h3>
        <p className="product-description">{product.description}</p>
        <p className="seller-tag">🏪 {product.seller}</p>
        <div className="product-footer">
          <span className="product-price">{formatPrice(product.price)}</span>
          <span className={`product-stock ${product.stock < 5 ? 'low' : ''}`}>{stockText}</span>
        </div>
        <button
          className="btn-add-cart"
          onClick={() => onAddToCart(product)}
          disabled={isOutOfStock}
        >
          {isOutOfStock ? '❌ Out of Stock' : '🛒 Add to Cart'}
        </button>
      </div>
    </div>
  );
}

export default ProductCard;