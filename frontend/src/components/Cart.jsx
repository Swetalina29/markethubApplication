import React from 'react';

function Cart({ cartItems, onClose, onUpdateQty, onRemoveItem, onCheckout }) {
  const formatPrice = (price) =>
    new Intl.NumberFormat('en-IN', { style: 'currency', currency: 'INR', maximumFractionDigits: 0 }).format(price);

  const total = cartItems.reduce((sum, item) => sum + item.price * item.quantity, 0);

  return (
    <>
      <div className="cart-overlay" onClick={onClose} />
      <div className="cart-sidebar">
        <div className="cart-header">
          <h2>🛒 Cart ({cartItems.length})</h2>
          <button className="btn-close" onClick={onClose}>✕</button>
        </div>

        <div className="cart-items">
          {cartItems.length === 0 && (
            <div className="empty-cart">
              <div className="emoji">🛒</div>
              <p>Your cart is empty</p>
            </div>
          )}
          {cartItems.map(item => (
            <div key={item.id} className="cart-item">
              <img
                src={item.imageUrl || 'https://via.placeholder.com/60x60'}
                alt={item.name}
                onError={e => { e.target.src = 'https://via.placeholder.com/60x60'; }}
              />
              <div className="cart-item-info">
                <div className="cart-item-name">{item.name}</div>
                <div className="cart-item-price">{formatPrice(item.price * item.quantity)}</div>
                <div className="cart-qty-controls">
                  <button className="qty-btn" onClick={() => onUpdateQty(item.id, item.quantity - 1)}>−</button>
                  <span>{item.quantity}</span>
                  <button className="qty-btn" onClick={() => onUpdateQty(item.id, item.quantity + 1)}>+</button>
                  <button className="qty-btn" onClick={() => onRemoveItem(item.id)} style={{ color: '#e44d26', marginLeft: 8 }}>🗑️</button>
                </div>
              </div>
            </div>
          ))}
        </div>

        {cartItems.length > 0 && (
          <div className="cart-footer">
            <div className="cart-total">
              <span>Total:</span>
              <span>{formatPrice(total)}</span>
            </div>
            <button className="btn-checkout" onClick={onCheckout}>
              Proceed to Checkout 🎉
            </button>
          </div>
        )}
      </div>
    </>
  );
}

export default Cart;