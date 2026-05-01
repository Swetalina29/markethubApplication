import React from 'react';

function Navbar({ cartCount, onCartOpen, onAddProduct }) {
  return (
    <nav className="navbar">
      <a className="navbar-brand" href="/">🛒 MarketHub</a>
      <ul className="navbar-nav">
        <li>
          <button className="nav-btn nav-btn-primary" onClick={onAddProduct}>
            + Sell Product
          </button>
        </li>
        <li>
          <button className="nav-btn nav-btn-outline" onClick={onCartOpen}>
            🛒 Cart
            {cartCount > 0 && <span className="cart-badge">{cartCount}</span>}
          </button>
        </li>
      </ul>
    </nav>
  );
}

export default Navbar;