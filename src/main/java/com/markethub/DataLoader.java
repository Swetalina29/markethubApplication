package com.markethub;

import com.markethub.model.Product;
import com.markethub.model.Product.Category;
import com.markethub.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            System.out.println("Loading sample products...");

            // ── ELECTRONICS ──────────────────────────────────────

            productRepository.save(new Product(null,
                "iPhone 15 Pro",
                "Latest Apple iPhone with A17 chip, 48MP camera, titanium design",
                129999.0, 15,
                "https://images.unsplash.com/photo-1695048133142-1a20484d2569?w=400",
                "TechStore India", Category.ELECTRONICS));

            productRepository.save(new Product(null,
                "Samsung Galaxy S24",
                "Android flagship with 200MP camera, 6.8 inch display, AI features",
                89999.0, 20,
                "https://images.unsplash.com/photo-1610945415295-d9bbf067e59c?w=400",
                "GadgetWorld", Category.ELECTRONICS));

            productRepository.save(new Product(null,
                "MacBook Air M2",
                "Apple MacBook Air with M2 chip, 8GB RAM, 256GB SSD, 13 inch display",
                114999.0, 10,
                "https://images.unsplash.com/photo-1611186871525-8b58f05e6947?w=400",
                "TechStore India", Category.ELECTRONICS));

            productRepository.save(new Product(null,
                "Sony WH-1000XM5 Headphones",
                "Industry leading noise cancellation, 30hr battery, foldable design",
                24999.0, 25,
                "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=400",
                "AudioWorld", Category.ELECTRONICS));

            productRepository.save(new Product(null,
                "Wireless Bluetooth Earbuds",
                "30hr battery, active noise cancellation, IPX5 water resistant",
                3499.0, 35,
                "https://images.unsplash.com/photo-1572569511254-d8f925fe2cbb?w=400",
                "TechStore India", Category.ELECTRONICS));

            productRepository.save(new Product(null,
                "iPad Pro 12.9 inch",
                "M2 chip, Liquid Retina XDR display, 5G capable, Apple Pencil support",
                109999.0, 8,
                "https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?w=400",
                "AppleZone", Category.ELECTRONICS));

            productRepository.save(new Product(null,
                "Canon DSLR Camera EOS 1500D",
                "24.1MP sensor, Full HD video, built-in WiFi, beginner friendly",
                34999.0, 12,
                "https://images.unsplash.com/photo-1516035069371-29a1b244cc32?w=400",
                "CameraShop", Category.ELECTRONICS));

            productRepository.save(new Product(null,
                "Smart LED TV 55 inch",
                "4K Ultra HD, Android TV, Dolby Vision, built-in Netflix and YouTube",
                49999.0, 7,
                "https://images.unsplash.com/photo-1593359677879-a4bb92f829d1?w=400",
                "ElectroMart", Category.ELECTRONICS));

            // ── CLOTHING ─────────────────────────────────────────

            productRepository.save(new Product(null,
                "Cotton Kurta Set",
                "Traditional Indian kurta with matching bottoms, multiple colors",
                1299.0, 75,
                "https://images.unsplash.com/photo-1583391733956-3750e0ff4e8b?w=400",
                "FashionIndia", Category.CLOTHING));

            productRepository.save(new Product(null,
                "Mens Formal Shirt",
                "100% cotton formal shirt, slim fit, available in white and blue",
                899.0, 60,
                "https://images.unsplash.com/photo-1603252109303-2751441dd157?w=400",
                "StyleHub", Category.CLOTHING));

            productRepository.save(new Product(null,
                "Women Saree Silk",
                "Pure silk saree with golden border, comes with matching blouse piece",
                4999.0, 30,
                "https://images.unsplash.com/photo-1610030469983-98e550d6193c?w=400",
                "SilkBazaar", Category.CLOTHING));

            productRepository.save(new Product(null,
                "Denim Jeans Slim Fit",
                "Stretchable slim fit jeans, comfortable for all day wear, sizes 28-38",
                1499.0, 80,
                "https://images.unsplash.com/photo-1542272454315-4c01d7abdf4a?w=400",
                "DenimWorld", Category.CLOTHING));

            // ── BOOKS ────────────────────────────────────────────

            productRepository.save(new Product(null,
                "Java Programming Complete Guide",
                "From beginner to advanced Java, 800 pages with exercises and projects",
                599.0, 100,
                "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c?w=400",
                "BookHub", Category.BOOKS));

            productRepository.save(new Product(null,
                "Clean Code by Robert Martin",
                "A handbook of agile software craftsmanship, must read for developers",
                799.0, 50,
                "https://images.unsplash.com/photo-1532012197267-da84d127e765?w=400",
                "TechBooks", Category.BOOKS));

            productRepository.save(new Product(null,
                "The Alchemist",
                "Paulo Coelho bestseller, an inspiring story about following your dreams",
                299.0, 150,
                "https://images.unsplash.com/photo-1544947950-fa07a98d237f?w=400",
                "BookHub", Category.BOOKS));

            productRepository.save(new Product(null,
                "Data Structures and Algorithms",
                "Comprehensive guide to DSA with Java examples, interview preparation",
                699.0, 80,
                "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=400",
                "TechBooks", Category.BOOKS));

            // ── HOME ─────────────────────────────────────────────

            productRepository.save(new Product(null,
                "Wooden Study Table",
                "Solid wood study table with drawer and shelf, 4 feet wide",
                8999.0, 10,
                "https://images.unsplash.com/photo-1518455027359-f3f8164ba6bd?w=400",
                "FurnitureCraft", Category.HOME));

            productRepository.save(new Product(null,
                "Air Purifier HEPA Filter",
                "Removes 99.9% dust pollen allergens, covers 400 sq ft room",
                8499.0, 15,
                "https://images.unsplash.com/photo-1585771724684-38269d6639fd?w=400",
                "HomeComfort", Category.HOME));

            productRepository.save(new Product(null,
                "Instant Pot Pressure Cooker",
                "7 in 1 multi cooker, 6 litre capacity, stainless steel inner pot",
                6999.0, 20,
                "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=400",
                "KitchenPro", Category.HOME));

            productRepository.save(new Product(null,
                "LED Desk Lamp",
                "Adjustable brightness, USB charging port, eye care technology",
                1299.0, 40,
                "https://images.unsplash.com/photo-1534073828943-f801091bb18c?w=400",
                "HomeComfort", Category.HOME));

            // ── SPORTS ───────────────────────────────────────────

            productRepository.save(new Product(null,
                "Men's Running Shoes",
                "Lightweight breathable running shoes with cushioning sole",
                2999.0, 50,
                "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=400",
                "SportZone", Category.SPORTS));

            productRepository.save(new Product(null,
                "Yoga Mat Premium",
                "6mm thick anti-slip eco-friendly yoga mat with carry strap",
                799.0, 60,
                "https://images.unsplash.com/photo-1601925228008-f5e6a3b29cc2?w=400",
                "FitLife", Category.SPORTS));

            productRepository.save(new Product(null,
                "Adjustable Dumbbells Set",
                "5kg to 25kg adjustable dumbbells, space saving home gym equipment",
                4999.0, 20,
                "https://images.unsplash.com/photo-1534438327276-14e5300c3a48?w=400",
                "FitLife", Category.SPORTS));

            productRepository.save(new Product(null,
                "Cricket Bat Kashmir Willow",
                "Full size cricket bat, Kashmir willow wood, for leather ball",
                1799.0, 35,
                "https://images.unsplash.com/photo-1531415074968-036ba1b575da?w=400",
                "SportZone", Category.SPORTS));

            productRepository.save(new Product(null,
                "Badminton Racket Set",
                "2 rackets plus 3 shuttlecocks, carbon fiber frame, for beginners",
                1299.0, 45,
                "https://images.unsplash.com/photo-1626224583764-f87db24ac4ea?w=400",
                "SportZone", Category.SPORTS));

            // ── OTHER ─────────────────────────────────────────────

            productRepository.save(new Product(null,
                "Leather Wallet Men",
                "Genuine leather slim wallet, RFID blocking, multiple card slots",
                799.0, 55,
                "https://images.unsplash.com/photo-1627123424574-724758594913?w=400",
                "AccessoryHub", Category.OTHER));

            productRepository.save(new Product(null,
                "Sunglasses Polarized",
                "UV400 protection polarized sunglasses, unisex, lightweight frame",
                999.0, 40,
                "https://images.unsplash.com/photo-1572635196237-14b3f281503f?w=400",
                "StyleHub", Category.OTHER));

            productRepository.save(new Product(null,
                "Scented Candle Set",
                "Set of 6 soy wax candles, lavender rose and vanilla fragrances",
                699.0, 65,
                "https://images.unsplash.com/photo-1603905621437-f8f5e2b9c6c5?w=400",
                "HomeDecor", Category.OTHER));

            productRepository.save(new Product(null,
                "Backpack Laptop 15.6 inch",
                "Water resistant, USB charging port, fits 15.6 inch laptop, 30L",
                1999.0, 30,
                "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=400",
                "BagWorld", Category.OTHER));

            productRepository.save(new Product(null,
                "Plant Pot Ceramic Set",
                "Set of 3 ceramic plant pots with drainage holes, modern design",
                899.0, 50,
                "https://images.unsplash.com/photo-1485955900006-10f4d324d411?w=400",
                "HomeDecor", Category.OTHER));

            System.out.println("✅ 30 products loaded successfully!");
        }
    }
}