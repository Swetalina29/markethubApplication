import React, { useState } from 'react';
import axios from 'axios';

var API = process.env.REACT_APP_API_URL || 'http://localhost:8080/api/products';

function AddProduct({ onClose, onSuccess }) {
  const [formData, setFormData] = useState({
    name: '', description: '', price: '', stock: '',
    seller: '', imageUrl: '', category: 'ELECTRONICS',
  });
  const [submitting, setSubmitting] = useState(false);
  const [error, setError] = useState('');

  const handleChange = e => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async () => {
    if (!formData.name || !formData.price || !formData.stock || !formData.seller) {
      setError('Please fill in all required fields.'); return;
    }
    try {
      setSubmitting(true);
      await axios.post(API, {
        ...formData,
        price: parseFloat(formData.price),
        stock: parseInt(formData.stock, 10),
      });
      onSuccess('🎉 Product listed successfully!');
      onClose();
    } catch {
      setError('Failed to add product. Please try again.');
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <div className="modal-overlay">
      <div className="modal">
        <div className="modal-header">
          <h2>📦 List a Product</h2>
          <button className="btn-close" onClick={onClose}>✕</button>
        </div>
        <div className="modal-body">
          {error && <p style={{ color: '#e44d26', marginBottom: 16 }}>⚠️ {error}</p>}

          <div className="form-group">
            <label>Product Name *</label>
            <input name="name" value={formData.name} onChange={handleChange} placeholder="e.g. Samsung Galaxy S24" />
          </div>

          <div className="form-group">
            <label>Description *</label>
            <textarea name="description" value={formData.description} onChange={handleChange} rows={3} placeholder="Describe your product..." />
          </div>

          <div className="form-row">
            <div className="form-group">
              <label>Price (₹) *</label>
              <input type="number" name="price" value={formData.price} onChange={handleChange} placeholder="999" min="0" />
            </div>
            <div className="form-group">
              <label>Stock *</label>
              <input type="number" name="stock" value={formData.stock} onChange={handleChange} placeholder="10" min="0" />
            </div>
          </div>

          <div className="form-row">
            <div className="form-group">
              <label>Shop Name *</label>
              <input name="seller" value={formData.seller} onChange={handleChange} placeholder="My Tech Store" />
            </div>
            <div className="form-group">
              <label>Category *</label>
              <select name="category" value={formData.category} onChange={handleChange}>
                <option value="ELECTRONICS">📱 Electronics</option>
                <option value="CLOTHING">👗 Clothing</option>
                <option value="BOOKS">📚 Books</option>
                <option value="HOME">🏠 Home</option>
                <option value="SPORTS">⚽ Sports</option>
                <option value="OTHER">📦 Other</option>
              </select>
            </div>
          </div>

          <div className="form-group">
            <label>Image URL (optional)</label>
            <input type="url" name="imageUrl" value={formData.imageUrl} onChange={handleChange} placeholder="https://example.com/image.jpg" />
          </div>

          <button className="btn-submit" onClick={handleSubmit} disabled={submitting}>
            {submitting ? '⏳ Adding...' : '🚀 List Product'}
          </button>
        </div>
      </div>
    </div>
  );
}

export default AddProduct;