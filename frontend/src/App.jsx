import React, { useState } from 'react';
import Navbar from './components/Navbar';
import ProductList from './components/ProductList';
import Cart from './components/Cart';
import AddProduct from './components/AddProduct';

function App() {
  const [cartItems, setCartItems]       = useState([]);
  const [cartOpen, setCartOpen]         = useState(false);
  const [addProductOpen, setAddProductOpen] = useState(false);
  const [toast, setToast]               = useState(null);

  const showToast = (msg) => {
    setToast(msg);
    setTimeout(() => setToast(null), 3000);
  };

  const handleAddToCart = (product) => {
    setCartItems(prev => {
      const existing = prev.find(i => i.id === product.id);
      if (existing)
        return prev.map(i => i.id === product.id ? { ...i, quantity: i.quantity + 1 } : i);
      return [...prev, { ...product, quantity: 1 }];
    });
    showToast(`✅ "${product.name}" added to cart!`);
  };

  const handleUpdateQty = (id, qty) => {
    if (qty <= 0) { handleRemoveItem(id); return; }
    setCartItems(prev => prev.map(i => i.id === id ? { ...i, quantity: qty } : i));
  };

  const handleRemoveItem = (id) => {
    setCartItems(prev => prev.filter(i => i.id !== id));
  };

  const handleCheckout = () => {
    alert(`🎉 Order placed! ${cartItems.length} items ordered. Thank you!`);
    setCartItems([]);
    setCartOpen(false);
  };

  const cartCount = cartItems.reduce((t, i) => t + i.quantity, 0);

  return (
    <div>
      <Navbar
        cartCount={cartCount}
        onCartOpen={() => setCartOpen(true)}
        onAddProduct={() => setAddProductOpen(true)}
      />
      <ProductList onAddToCart={handleAddToCart} />
      {cartOpen && (
        <Cart
          cartItems={cartItems}
          onClose={() => setCartOpen(false)}
          onUpdateQty={handleUpdateQty}
          onRemoveItem={handleRemoveItem}
          onCheckout={handleCheckout}
        />
      )}
      {addProductOpen && (
        <AddProduct
          onClose={() => setAddProductOpen(false)}
          onSuccess={showToast}
        />
      )}
      {toast && <div className="toast">{toast}</div>}
    </div>
  );
}

export default App;