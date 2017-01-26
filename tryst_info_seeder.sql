
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
        (1, 'flemings-prime-steakhouse-and-wine-bar-san-antonio', 2, 11, 1),
        (1, 'soho-wine-and-martini-bar-san-antonio', 5, 11, 1),
        (1, 'bohanans-prime-steaks-and-seafood-san-antonio', 2, 5, 11, 1),
        (1, 'biga-on-the-banks-san-antonio', 2, 5, 11, 1),
        (1, 'fogo-de-chão-brazilian-steakhouse-san-antonio-5', 2, 5, 11, 1),
        (1, 'the-esquire-tavern-san-antonio', 2, 11, 9, 1),
        (1, 'cured-san-antonio-2', 11, 2, 1),
        (1, 'bakery-lorraine-san-antonio', 1, 6, 7, 10, 1),
        (1, 'local-coffee-san-antonio-6', 1, 10, 1),
        (1, 'yelp-at-jazz-tx-san-antonio', 2, 5, 8, 9, 11, 1),
        (1, 'rosella-coffee-san-antonio', 1, 10, 1),
        (1, 'high-street-wine-company-san-antonio', 6, 7, 10, 1),
        (1, 'crepelandia-san-antonio-2', 1, 6, 10, 1),
        (1, 'southerleigh-fine-food-and-brewery-san-antonio', 2, 5, 11, 1),
        (1, 'the-granary-cue-and-brew-san-antonio', 1, 7, 1),
        (1, 'camden-street-riverwalk-bridge-san-antonio', 3, 4, 5, 7, 8, 11, 1),
        (1,'the-luxury-san-antonio', 1, 3, 7, 8, 10, 1),
        (1, 'the-brooklynite-san-antonio', 5, 7, 11, 1),
        (1, 'stay-golden-social-house-san-antonio', 1, 7, 10, 1),
        (1, 'guillermos-san-antonio', 1, 10, 1),
        (1, 'tobin-center-for-the-performing-arts-san-antonio-2', 2, 4, 5, 8, 9, 11, 1),
        (1, 'tobin-plaza-san-antonio', 1, 3, 4, 10, 1),
        (1, 'ocho-san-antonio', 2, 5, 9, 11, 1),
        (1, 'overtime-theater-san-antonio', 1, 6, 7, 8, 10, 1),
        (1, 'opera-san-antonio-san-antonio', 2, 5, 8, 9, 11, 1),
        (1, 'high-wire-art-gallery-san-antonio', 7, 8, 10, 11, 1),
        (1, 'havana-bar-san-antonio', 5, 8, 11, 1),
        (1, 'south-alamode-panini-and-gelato-company-san-antonio', 1, 7, 10, 1),
        (1, 'ro-ho-pork-and-bread-san-antonio', 1, 7, 10, 1),
        (1, '1919-san-antonio', 5, 11, 1),
        (1, 'la-tuna-grill-san-antonio', 1, 10, 1),
        (1, 'il-forno-san-antonio', 1, 7, 1),
        (1, 'press-coffee-san-antonio', 1, 6, 7, 10, 1),
        (1, 'cookhouse-san-antonio-2', 5, 7, 11, 1),
        (1, 'edera-osteria-enoteca-san-antonio', 2, 5, 11, 1),
        (1, 'cullums-attagirl-san-antonio-2', 1, 7, 10, 1),
        (1, 'la-fonda-on-main-san-antonio', 1, 7, 11, 1),
        (1, 'pugels-san-antonio', 1, 10, 1),
        (1, 'park-social-olmos-park', 5, 7, 8, 10, 11, 1),
        (1, 'barbaro-san-antonio', 1, 6, 7, 8, 1),
        (1, 'tycoon-flats-san-antonio', 1, 7, 1),
        (1, 'green-vegetarian-cuisine-at-pearl-brewery-san-antonio', 1, 7, 1),
        (1, 'fratellos-italian-market-and-deli-san-antonio', 1, 7, 10, 1),
        (1, 'olmos-perk-san-antonio', 1, 6, 7, 10, 1),
        (1, 'the-clean-plate-san-antonio-san-antonio', 1, 7, 1),
        (1, 'commonwealth-coffeehouse-and-bakery-san-antonio-3', 1, 6, 7, 10, 1),
        (1, 'nikis-tokyo-inn-san-antonio', 2, 5, 11, 1),
        (1, 'babios-night-club-san-antonio', 9, 10, 1),
        (1, 'pizza-classics-san-antonio-2', 1, 10, 1),
        (1, 'candlelight-coffeehouse-san-antonio-6', 1, 5, 6, 7, 8, 10, 1),
        (1, 'the-cove-san-antonio', 1, 7, 9, 10, 1),
        (1, 'bella-on-the-river-san-antonio', 2, 3, 4, 5, 11, 1),
        (1, 'nectar-wine-bar-and-ale-house-san-antonio', 1, 6, 7, 8, 10, 11, 1),
        (1, 'restaurant-gwendolyn-san-antonio', 2, 5, 8, 11, 1),
        (1, 'la-villita-cafe-san-antonio', 1, 7, 10, 1),
        (1, 'the-station-cafe-san-antonio', 1, 7, 10, 1),
        (1, 'the-house-boozy-ice-cream-and-brews-san-antonio-2', 1, 5, 10, 1),
        (1, 'paper-tiger-san-antonio', 7, 8, 9, 10, 1),
        (1, 'vfw-post-76-san-antonio', 7, 8, 9, 10, 1),
        (1, 'southtown-101-san-antonio', 7, 8, 9, 10, 1),
        (1, 'limelight-san-antonio-2', 7, 8, 9, 10, 1),
        (1, 'hi-tones-san-antonio', 9, 10, 1),
        (1, 'tba-san-antonio-2', 1, 9, 10, 1),
        (1, 'frank-san-antonio', 1, 7, 10, 1),
        (1, 'the-amp-room-san-antonio', 7, 9, 10, 1),
        (1, 'laugh-out-loud-comedy-club-san-antonio', 1, 2, 6, 7, 1),
        (1, 'alamo-city-improv-san-antonio', 1, 2, 6, 7, 1),
        (1, 'majestic-theatre-san-antonio-san-antonio', 1, 2, 5, 6, 7, 8, 9, 11, 1),
        (1, 'the-aztec-theatre-san-antonio-3', 1, 7, 8, 9, 11, 1);








