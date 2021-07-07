INSERT INTO roles(name) VALUES('USER');
INSERT INTO roles(name) VALUES('MODERATOR');
INSERT INTO roles(name) VALUES('ADMIN');

INSERT INTO skills(name, slug, position) VALUES('JAVA', 'java', 1);
INSERT INTO skills(name, slug, position ) VALUES('JAVASCRIPT', 'javascript', 2);
INSERT INTO skills(name, slug, position) VALUES('ANGULAR', 'angular', 3);

INSERT INTO persons(first_name, last_name, birthday, email, mobile, telephone, addres, created_at, updated_at)
VALUES		('William', 'Shakespeare', '1564-12-12', 'wish@email.com', '999 999 999', '564 234', 'N/A', CURDATE(), CURDATE()),
			('Charles', 'Dickens', '1812-12-12', 'chdi@email.com', '999 999 999', '564 234', 'N/A', CURDATE(), CURDATE()),
            ('James', 'Joyce', '1941-12-12', 'jajo@email.com', '999 999 999', '564 234', 'N/A', CURDATE(), CURDATE()),
            ('Marcel', 'Proust', '1871-12-12', 'mapr@email.com', '999 999 999', '564 234', 'N/A', CURDATE(), CURDATE()),
            ('Franz', 'Kafka', '1883-12-12', 'frka@email.com', '999 999 999', '564 234', 'N/A', CURDATE(), CURDATE()),
			('Oscar', 'Wilde', '1854-12-12', 'mapr@email.com', '999 999 999', '564 234', 'N/A', CURDATE(), CURDATE()),
            ('Pablo', 'Neruda', '1904-12-12', 'pane@email.com', '999 999 999', '564 234', 'N/A', CURDATE(), CURDATE()),
            ('Juan', 'Rulfo', '1917-12-12', 'juru@email.com', '999 999 999', '564 234', 'N/A', CURDATE(), CURDATE()),
            ('Julio', 'Cortazar', '1914-12-12', 'juco@email.com', '999 999 999', '564 234', 'N/A', CURDATE(), CURDATE()),
            ('Albert', 'Camus', '1913-12-12', 'alca@email.com', '999 999 999', '564 234', 'N/A', CURDATE(), CURDATE()),
            ('Victor', 'Hugo', '1802-12-12', 'vihu@email.com', '999 999 999', '564 234', 'N/A', CURDATE(), CURDATE()),
            ('Eduardo', 'Galeano', '1940-12-12', 'vihu@email.com', '999 999 999', '564 234', 'N/A', CURDATE(), CURDATE());