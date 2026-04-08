<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
        <title>Tasca 3</title>
    </head>
    <body>
        <form action="consultes.php" method="POST">
                <p>1. Obtenir els cognoms dels empleats. 
                    <label for="PDO1">PDO <input id="PDO1" type="radio" name="consulta" value="PDO1"></label>
                    <label for="MSQLi1">MSQLi <input id="MSQLi1" type="radio" name="consulta" value="MSQLi1"></label>
                </p>
                <p>2. Obtenir els cognoms dels empleats sense repeticions. 
                    <label for="PDO2">PDO <input id="PDO2" type="radio" name="consulta" value="PDO2"></label>
                    <label for="MSQLi2">MSQLi <input id="MSQLi2" type="radio" name="consulta" value="MSQLi2"></label>
                </p>

                <p>3. Obtenir totes les dades dels empleats que es diuen 'López'. 
                    <label for="PDO3">PDO <input id="PDO3" type="radio" name="consulta" value="PDO3"></label>
                    <label for="MSQLi3">MSQLi <input id="MSQLi3" type="radio" name="consulta" value="MSQLi3"></label>
                </p>

                <p>4. Obtenir totes les dades dels empleats que es diuen 'López' i dels que es diuen 'Pérez'. 
                    <label for="PDO4">PDO <input id="PDO4" type="radio" name="consulta" value="PDO4"></label>
                    <label for="MSQLi4">MSQLi <input id="MSQLi4" type="radio" name="consulta" value="MSQLi4"></label>
                </p>

                <p>5. Obtenir totes les dades dels empleats que treballen per al departament 714. 
                    <label for="PDO5">PDO <input id="PDO5" type="radio" name="consulta" value="PDO5"></label>
                    <label for="MSQLi5">MSQLi <input id="MSQLi5" type="radio" name="consulta" value="MSQLi5"></label>
                </p>

                <p>6. Obtenir totes les dades dels empleats que treballen pel departament 737 i pel departament 777. 
                    <label for="PDO6">PDO <input id="PDO6" type="radio" name="consulta" value="PDO6"></label>
                    <label for="MSQLi6">MSQLi <input id="MSQLi6" type="radio" name="consulta" value="MSQLi6"></label>
                </p>

                <p>7. Obtenir totes les dades dels empleats els quals el cognom comenci per 'P'. 
                    <label for="PDO7">PDO <input id="PDO7" type="radio" name="consulta" value="PDO7"></label>
                    <label for="MSQLi7">MSQLi <input id="MSQLi7" type="radio" name="consulta" value="MSQLi7"></label>
                </p>
                <p>8. Obtenir el pressupost total de tots els departaments. 
                    <label for="PDO8">PDO <input id="PDO8" type="radio" name="consulta" value="PDO8"></label>
                    <label for="MSQLi8">MSQLi <input id="MSQLi8" type="radio" name="consulta" value="MSQLi8"></label>
                </p>

                <p>9. Obtenir el nombre d'empleats de cada departament. 
                    <label for="PDO9">PDO <input id="PDO9" type="radio" name="consulta" value="PDO9"></label>
                    <label for="MSQLi9">MSQLi <input id="MSQLi9" type="radio" name="consulta" value="MSQLi9"></label>
                </p>

                <p>10. Obtenir un llistat complet d'empleats amb les dades de l'empleat i del seu departament. 
                    <label for="PDO10">PDO <input id="PDO10" type="radio" name="consulta" value="PDO10"></label>
                    <label for="MSQLi10">MSQLi <input id="MSQLi10" type="radio" name="consulta" value="MSQLi10"></label>
                </p>
                <p>11. Obtenir un llistat complet d'empleats amb el nom, cognoms, departament i pressupost. 
                    <label for="PDO11">PDO <input id="PDO11" type="radio" name="consulta" value="PDO11"></label>
                    <label for="MSQLi11">MSQLi <input id="MSQLi11" type="radio" name="consulta" value="MSQLi11"></label>
                </p>
                <p>12. Obtenir els noms i cognoms dels empleats que treballen en departaments els quals el pressupost sigui més gran que 60,000€. 
                    <label for="PDO12">PDO <input id="PDO12" type="radio" name="consulta" value="PDO12"></label>
                    <label for="MSQLi12">MSQLi <input id="MSQLi12" type="radio" name="consulta" value="MSQLi12"></label>
                </p>
                <p>13. Obtenir les dades dels departaments els quals el pressupost és superior al pressupost mitjà de tots els departaments. 
                    <label for="PDO13">PDO <input id="PDO13" type="radio" name="consulta" value="PDO13"></label>
                    <label for="MSQLi13">MSQLi <input id="MSQLi13" type="radio" name="consulta" value="MSQLi13"></label>
                </p>
                <p>14. Obtenir els noms dels departaments que tenen més de dos empleats. 
                    <label for="PDO14">PDO <input id="PDO14" type="radio" name="consulta" value="PDO14"></label>
                    <label for="MSQLi14">MSQLi <input id="MSQLi14" type="radio" name="consulta" value="MSQLi14"></label>
                </p>
                <p>15. Afegir un nou departament: 'Qualitat', amb pressupost de 40,000€ i codi '11'. Afegir un empleat vinculat al departament recentment creat: Esther Vázquez, DNI: 89.267.109
                    <label for="PDO15">PDO <input id="PDO15" type="radio" name="consulta" value="PDO15"></label>
                    <label for="MSQLi15">MSQLi <input id="MSQLi15" type="radio" name="consulta" value="MSQLi15"></label>
                </p>
                <p>16. Aplicar una retallada pressupostària del 10% a tots els departaments. 
                    <label for="PDO16">PDO <input id="PDO16" type="radio" name="consulta" value="PDO16"></label>
                    <label for="MSQLi16">MSQLi <input id="MSQLi16" type="radio" name="consulta" value="MSQLi16"></label>
                </p>
                <p>17. Reassignar els empleats del departament 777 al departament 714. 
                    <label for="PDO17">PDO <input id="PDO17" type="radio" name="consulta" value="PDO17"></label>
                    <label for="MSQLi17">MSQLi <input id="MSQLi17" type="radio" name="consulta" value="MSQLi17"></label>
                </p>
                <p>18. Acomiadar a tots els empleats que treballen pel departament 714. 
                    <label for="PDO18">PDO <input id="PDO18" type="radio" name="consulta" value="PDO18"></label>
                    <label for="MSQLi18">MSQLi <input id="MSQLi18" type="radio" name="consulta" value="MSQLi18"></label>
                </p>
                <p>19. Acomiadar a tots els empleats que treballin per departaments els quals el pressupost sigui superior als 60,000€. 
                    <label for="PDO19">PDO <input id="PDO19" type="radio" name="consulta" value="PDO19"></label>
                    <label for="MSQLi19">MSQLi <input id="MSQLi19" type="radio" name="consulta" value="MSQLi19"></label>
                </p>
                <p>20. Acomiadar a tots els empleats. 
                    <label for="PDO20">PDO <input id="PDO20" type="radio" name="consulta" value="PDO20"></label>
                    <label for="MSQLi20">MSQLi <input id="MSQLi20" type="radio" name="consulta" value="MSQLi20"></label>
                </p>
            <button type="submit" name="enviar">Enviar</button>
        </form>
    </body>
</html>