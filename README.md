# Backend-solicitudes

El sistema consiste en un formulario para crear solicitudes de facturas


a continuacion: modelo entidad-relacion
![Test Image 6](https://github.com/juan-urrego/Backend-solicitudes/blob/master/Solicitudes.png)





# Inicializacion

Dercagamos e instalamos 
-Glassfish 5.0 : http://download.oracle.com/glassfish/5.0/release/glassfish-5.0.zip

-mysql 8

-conector-mysql.jar v8

-Openjdk 11 y 8

Importar DB 

1. extraemos glassfish.zip
2. en el IDE configuramos el servidor y le damos la ruta a la carpeta descomprimida
3. el conector-mysql-jar se debe mover a la ruta : glassfish5\glassgish\lib
4. en el IDE click derecho en "view domain admin console"

## Configuracion mysql
1. despues de cargar el panel de control de glassfish
2. vamos a la seccion de JDBC 
3. JDBC Connection pools
4. new
5.Pool Name : SolicitudPool
              java.sql.conectionpoolDataSource
              mysql
     Next
6. Datasource Classname: com.mysql.cj.jdbc.MysqlDataSource
7. Parametros: 
![Test Image 1](https://github.com/juan-urrego/Backend-solicitudes/blob/master/Pool.png)
8. save
9. probar ping una vez creada el conector

10. en JDBC Resources
11. new
12. name : jdbc/SolicitudDb
13. Conection Pool: Seleccionamos la que creamos (SolicitudPool)
