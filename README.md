# jk_lb_test
mod_jk load balancing test lab

## Lista delle url della web app:

### setSleep
PUT http://localhost:8080/web-sample/setSleep/{sleep}
Inserisce un tempo di servizio pari a "sleep" millisecondi.

## service
GET http://localhost:8080/web-sample/service
Restituisce una pagina dopo "sleep" millisecondi con la stampa del numero di esecuzione.

## Catch-all pages
GET http://localhost:8080/web-sample/all
GET http://localhost:8080/web-sample/all/**
Restituisce una pagina con la stampa del numero di esecuzione e lo sleep attuale.

