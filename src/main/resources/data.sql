-- Check if the admin already exists before inserting
INSERT INTO admin (username, password, role)
SELECT 'Sandip', '$2a$10$bD1iwRv5bNHCc7jU5fT9deofZUZaHyFQQHNRmK99HTAcWOJTTv1vy', 'ADMIN'
WHERE NOT EXISTS (SELECT 1 FROM admin WHERE username = 'Sandip');
-- The password is BCrypt encoded 'Sandip@2023'