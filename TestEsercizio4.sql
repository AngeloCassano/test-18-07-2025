-- query 1 Elenca tutti i film rilasciati dopo il 2005, ordinati per titolo in ordine alfabetico
SELECT film.title, film.release_year
FROM film
WHERE film.release_year>2005
ORDER BY film.title ASC;

-- query 2 Mostra tutti i noleggi (rental) effettuati da un cliente di nome Mary Smith. 
SELECT customer.first_name, customer.last_name, rental.rental_id, rental.inventory_id, rental.rental_date
FROM customer
INNER JOIN rental on customer.customer_id = rental.rental_id
WHERE customer.first_name = 'Mary' AND customer.last_name = 'Smith';

-- query 3 Per ogni film, mostra il numero totale di volte in cui è stato noleggiato (usa JOIN e GROUP BY). 
SELECT film.title, COUNT(film.title) AS NumeroNoleggi
FROM rental
INNER JOIN inventory on rental.inventory_id = inventory.inventory_id
INNER JOIN film on inventory.film_id = film.film_id
GROUP BY film.title;

-- query 4 Elenca i nomi dei film che non sono mai stati noleggiati.
SELECT film.title
FROM film
WHERE film.title NOT IN(
SELECT film.title
FROM rental
INNER JOIN inventory on rental.inventory_id = inventory.inventory_id
INNER JOIN film on inventory.film_id = film.film_id);

-- query 5 Trova il genere (category) con il maggior numero di noleggi.
SELECT category.name, COUNT(category.category_id) AS NUmeroNoleggi
FROM rental
INNER JOIN inventory on rental.inventory_id = inventory.inventory_id
INNER JOIN film on inventory.film_id = film.film_id
INNER JOIN film_category on film.film_id = film_category.category_id
INNER JOIN category on film_category.category_id = category.category_id
GROUP BY category.category_id
ORDER BY NumeroNoleggi
LIMIT 1
;

