INSERT INTO producers (id, name, created_at) VALUES 
('6b2520b1-3695-450b-9e66-39ec4356a97c', 'Adidas', NOW()),
('870eb3e0-6a28-46fd-a763-0f8b47aa8034', 'Nike', NOW());

INSERT INTO marketplaces (id, description) VALUES 
('amazon.ae', 'Amazon UAE'),
('ebay.com', 'eBay');

INSERT INTO seller_infos (id, marketplace_id, name, url, country, external_id) VALUES 
('057cd7ba-4088-4ff1-be69-c4f4847ed8a8', 'amazon.ae', 'Amazon US', 'https://www.amazon.com', 'US', 'A2QUTRSO1ZHRN9'),
('0c4cd951-0256-4d5e-95a6-51a7c8c5174f', 'ebay.com', 'eBay UK', 'https://www.ebay.co.uk', 'UK', 'B3QUTRSO1ZHRN8');

INSERT INTO sellers (id, producer_id, seller_info_id, state) VALUES 
('11111111-1111-1111-1111-111111111111', '6b2520b1-3695-450b-9e66-39ec4356a97c', '057cd7ba-4088-4ff1-be69-c4f4847ed8a8', 'BLACKLISTED'),
('22222222-2222-2222-2222-222222222222', '870eb3e0-6a28-46fd-a763-0f8b47aa8034', '0c4cd951-0256-4d5e-95a6-51a7c8c5174f', 'BLACKLISTED');