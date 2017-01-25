
use tryst_db;

INSERT INTO users (email, home_zip, password,  username)
    VALUES
        ('admin@tryst.com', '78209', '$2a$10$agOiOUWSGGV5dWEKSD8MhuSSZiYtfZM9rzzB1dsePhEK/Ld2gn/Eu', 'admin');

INSERT INTO date_categories (date_type)
    VALUES
        ('Casual First Date'),
        ('Anniversary'),
        ('Outdoors'),
        ('Sight Seeing'),
        ('Romantic Date'),
        ('Relaxing Date'),
        ('First Date IRL'),
        ('Artsy'),
        ('Live Music'),
        ('No $$ No Problem'),
        ('Classy');


INSERT INTO tryst_rankings (rating, yelp_id, date_category_id, user_id)
    VALUES
        (1,'local-coffee-san-antonio-3', 7, 1),
        (1, 'paciugo-san-antonio-san-antonio',1, 1),
        (1, 'bar-du-mon-ami-san-antonio', 11, 1),
        (1, 'commonwealth-coffeehouse-and-bakery-san-antonio-3', 1, 1),
        (1, 'cappys-restaurant-san-antonio', 5, 1),
        (1, 'cerronis-purple-garlic-san-antonio', 1, 1),
        (1, 'chelas-tacos-san-antonio-3', 1, 1),
        (1, 'paloma-blanca-mexican-cuisine-san-antonio-2', 5, 1),
        (1, 'habibi-cafe-san-antonio', 7, 1),
        (1, 'torchys-tacos-san-antonio', 7, 1),
        (1, 'sorrento-pizza-and-restaurant-san-antonio', 7, 1),
        (1, 'la-panaderia-san-antonio', 7, 1),
        (1, 'theory-coffee-company-san-antonio', 7, 1),
        (1, 'cappyccinos-san-antonio', 7, 1),
        (1, 'flemings-prime-steakhouse-and-wine-bar-san-antonio', 2);
