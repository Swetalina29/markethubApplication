import React, { useState, useEffect } from 'react';
import axios from 'axios';
import ProductCard from './ProductCard';

const API = 'http://localhost:8080/api/products';
const CATEGORIES = ['ALL','ELECTRONICS','CLOTHING','BOOKS','HOME','SPORTS','OTHER'];

function ProductList({ onAddToCart }) {
  const [products, setProducts]   = useState([]);
  const [loading, setLoading]     = useState(true);
  const [error, setError]         = useState(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [activeCategory, setActiveCategory] = useState('ALL');

  useEffect(() => { fetchProducts(); }, []);

  const fetchProducts = async () => {
    try {
      setLoading(true);
      const res = await axios.get(API);
      setProducts(res.data);
      setError(null);
    } catch {
      setError('Failed to load products. Is Spring Boot running?');
    } finally {
      setLoading(false);
    }
  };

  const handleSearch = async () => {
    if (!searchTerm.trim()) { fetchProducts(); return; }
    try {
      setLoading(true);
      const res = await axios.get(`${API}/search?keyword=${searchTerm}`);
      setProducts(res.data);
      setActiveCategory('ALL');
    } catch { setError('Search failed.'); }
    finally { setLoading(false); }
  };

  const handleCategory = async (cat) => {
    setActiveCategory(cat);
    if (cat === 'ALL') { fetchProducts(); return; }
    try {
      setLoading(true);
      const res = await axios.get(`${API}/category/${cat}`);
      setProducts(res.data);
    } catch { setError('Filter failed.'); }
    finally { setLoading(false); }
  };

  return (
    <div>
      <div className="hero">
        <h1>🛒 MarketHub</h1>
        <p>Buy and sell products from thousands of sellers</p>
        <div className="search-bar">
          <input
            type="text"
            placeholder="Search products..."
            value={searchTerm}
            onChange={e => setSearchTerm(e.target.value)}
            onKeyPress={e => e.key === 'Enter' && handleSearch()}
          />
          <button onClick={handleSearch}>🔍 Search</button>
        </div>
      </div>

      <div className="container">
        <div className="filters">
          {CATEGORIES.map(cat => (
            <button
              key={cat}
              className={`filter-btn ${activeCategory === cat ? 'active' : ''}`}
              onClick={() => handleCategory(cat)}
            >
              {cat === 'ALL' && '🌐 All'}
              {cat === 'ELECTRONICS' && '📱 Electronics'}
              {cat === 'CLOTHING' && '👗 Clothing'}
              {cat === 'BOOKS' && '📚 Books'}
              {cat === 'HOME' && '🏠 Home'}
              {cat === 'SPORTS' && '⚽ Sports'}
              {cat === 'OTHER' && '📦 Other'}
            </button>
          ))}
        </div>

        <div className="products-header">
          <h2>Products</h2>
          <span className="product-count">{products.length} found</span>
        </div>

        {loading && <div className="loading"><span className="loading-spinner">⏳</span> Loading...</div>}
        {!loading && error && <div className="no-products">⚠️ {error}</div>}
        {!loading && !error && products.length === 0 && <div className="no-products">😕 No products found.</div>}
        {!loading && !error && products.length > 0 && (
          <div className="products-grid">
            {products.map(p => (
              <ProductCard key={p.id} product={p} onAddToCart={onAddToCart} />
            ))}
          </div>
        )}
      </div>
    </div>
  );
}

export default ProductList;