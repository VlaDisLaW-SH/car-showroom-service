INSERT INTO vehicles (brand, model, issue_year, price, status, body_type, description, created_at) VALUES
('Audi', 'A6', '2005', 7000, 'In stock', 'Sedan', 'Комфортный седан с хорошей динамикой.', NOW()),
('BMW', 'X5', '2002', 10000, 'In stock', 'SUV', 'Просторный внедорожник с полным приводом.', NOW()),
('Mercedes', 'C-Class', '2018', 25000, 'Sold', 'Sedan', 'Элегантный седан с современными технологиями.', NOW()),
('Toyota', 'Camry', '2003', 5000, 'In stock', 'Sedan', 'Надежный и экономичный седан.', NOW()),
('Ford', 'Focus', '2015', 18000, 'In stock', 'Hatchback', 'Компактный хэтчбек с хорошими характеристиками.', NOW()),
('Nissan', 'Altima', '2010', 12000, 'In stock', 'Sedan', 'Спортивный седан с хорошей экономией топлива.', NOW()),
('Kia', 'Sportage', '2016', 20000, 'In stock', 'SUV', 'Удобный и надежный кроссовер.', NOW()),
('Chevrolet', 'Impala', '2014', 16000, 'Sold', 'Sedan', 'Просторный седан с мощным двигателем.', NOW()),
('Hyundai', 'Elantra', '2019', 22000, 'In stock', 'Sedan', 'Современный седан с множеством функций безопасности.', NOW()),
('Subaru', 'Outback', '2017', 23000, 'In stock', 'Wagon', 'Полный привод и отличная проходимость.', NOW()),
('Volkswagen', 'Golf', '2018', 19000, 'Sold', 'Hatchback', 'Классический хэтчбек с отличными характеристиками.', NOW()),
('Mazda', 'CX-5', '2020', 28000, 'In stock', 'SUV', 'Спортивный кроссовер с отличной управляемостью.', NOW()),
('Honda', 'Civic', '2015', 17000, 'In stock', 'Sedan', 'Надежный и экономичный автомобиль с хорошими отзывами.', NOW()),
('Porsche', 'Macan', '2021', 60000, 'In stock', 'SUV', 'Элегантный и мощный кроссовер.', NOW()),
('Fiat', '500', '2013', 8000, 'Sold', 'Hatchback', 'Компактный и стильный городской автомобиль.', NOW());

INSERT INTO customers (full_name, phone_number, email, password, created_at) VALUES
('Иван Иванов', '+7(123)456-78-90', 'ivan.ivanov@example.com', 'password123', NOW()),
('Мария Петрова', '+7(234)567-89-01', 'maria.petrova@example.com', 'securepass456', NOW()),
('Сергей Сидоров', '+7(345)678-90-12', 'sergey.sidorov@example.com', 'mypassword789', NOW()),
('Алексей Смирнов', '+7(456)789-01-23', 'aleksey.smirnov@example.com', 'pass1234', NOW()),
('Ольга Кузнецова', '+7(567)890-12-34', 'olga.kuznetsova@example.com', 'mypassword567', NOW());