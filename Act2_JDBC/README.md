
#¡Bienvenido a la aplicación de gestión de coches con JDBC!


**Objetivos**

Aprender a manejar JDBC mediante una pequeña aplicación de gestión de coches


**Pautas de elaboración:**

--- REQUERIMIENTO 1 ---

Se desea hacer un CRUD completo de la entidad ‘Coche’, pero esta vez no se trabajará con ningún fichero, se trabajará con una BBDD. Es muy importante usar el patrón DAO visto en clase. Los parámetros de conexión a la BBDD deben estar hechos en un fichero de propiedades.

Atributos del Coche:
* ID
* Marca
* Modelo
* Año de Fabricación
* Kilometraje


Menú Principal:
* Añadir nuevo coche (El ID se incrementará automáticamente en la base de datos)
* Borrar coche por ID
* Consultar coche por ID
* Modificar coche por ID (Se solicitarán todos los valores y se modificarán a partir del ID del coche)
* Listado de coches
* Terminar el programa

---

--- REQUERIMIENTO 2 ---

Se pide añadir la siguiente funcionalidad.

Los coches, tendrán asociados N pasajeros en él (habrá que crear la tabla pasajeros y hacer la relación pertinente). Los pasajeros tendrán los siguientes atributos, id, nombre, edad y peso. Se agregará una opción de "gestión de pasajeros" al menú principal.

Atributos de los pasajeros:
* ID
* nombre
* edad
* peso

Submenú de Gestión de Pasajeros:
* Crear nuevo pasajero
* Borrar pasajero por ID
* Consultar pasajero por ID
* Listar todos los pasajeros
* Añadir pasajero a coche: el programa solicitará el ID de un pasajero y el ID de un coche, y los asociará en la base de datos.
* Eliminar pasajero de un coche: el programa solicitará el ID de un pasajero y lo eliminará del coche en la base de datos.
* Listar todos los pasajeros de un coche: el programa solicitará el ID de un coche y mostrará todos los pasajeros asociados a él.

---

--- REQUERIMIENTO 3 ---

La aplicación no debe permitir que la marca y el modelo estén vacíos. Esta parte la debe de gestionar la capa gestora y seguir el modelo de tres capas visto en clase.

