# __CVDS-LAB5__

## __Requisitos__
A continución los requisitos, para poder realizar el Laboratorio
* Tener habilitado **Telnet de Windows 10** ya que viene deshabilitado por defecto.
* Tener instalado **Cygwin Terminal**, si es de sistema operativo windows y presenta problemas. **(Opcional)**
  
## __Instalación de requisitos__
*  En caso de no tener habilitado **Telnet de Windows 10** activo seguir los siguientes pasos:
   * Buscar el cmd de windows y ejecutarlo como administrador \
   ![Imag1](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/InstallTelnetStep1.jpg)
   * Ejecutar el siguiente comando \
   ![Imag2](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/InstallTelnetStep2.png)
*   En caso de no tener Cygwin Terminal, [instalacion del terminal](https://cygwin.com/install.html)
## __Introducción a proyectos Web__ 




### __Parte I. - Jugando a ser un cliente HTTP__

1. Abra una terminal Linux o consola de comandos Windows.
2. Realice una conexión síncrona TCP/IP a través de Telnet al siguiente servidor:
   * Host: www.escuelaing.edu.co
   * Puerto: 80 
    
3. Antes de que el servidor cierre la conexión por falta de comunicación
   * realizar una petición GET. Con esto, solicite al servidor el recurso ```‘sssss/abc.html’```, usando la ```versión 1.0 de HTTP```. 

    **Solicitando el recurso html**:  
    Ejecute el comando ```telnet HOST PORT```
    ```
    $ telnet www.escuelaing.edu.co 80
    ```
    
    Se debera realizar la solicitud GET, introduciendo el comando:
    ```
    $ GET /sssss/abc.html HTTP/1.0
    ```
    Con esta solicitud  saldran los siguientes errores/mensajes: 

  * __Error 400: Bad request__: Indica que el sitio web o Host, no reconoce el comando o la solicitud del cliente porque esta no respeta el protocolo HTTP, por ende no la puede procesar.

    ![Imag3](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/Error400.png)

   * __Error 301: Moved permanently__: Indica que el host ha sido capaz de comunicarse con 
el servidor pero que el recurso solicitado ha sido movido a otra dirección permanentemente.  
    ![Imag4](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/Error301.png)  

   * __¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?__ \
   ![Imagn](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/StatusCode.png)  

4. Realice una nueva conexión con telnet, esta vez a: 
   * Host: www.httpbin.org
   * Puerto: 80

 * **Solicitando el recurso html**:  \
    Ahora, solicite el recurso /html. (GET), Ejecute el comando ```telnet HOST PORT```
    ```
    $ telnet www.httpbin.org 80
    ```
    
    Se debera realizar la solicitud GET, introduciendo el comando:
    ```
    $ GET /html HTTP/1.0
    ```
    Como resultado se tendra el siguiente html \
    ![Imag5](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/GEThttpbin.png)

5. Seleccione el contenido ```HTML``` de la respuesta y copielo al cortapapeles ```CTRL-SHIFT-C```. Ejecute el comando ```wc``` (word count) para contar palabras con la opción ```-c``` para contar el número de caracteres:
   ```
   $ wc -c 
   ```
   Nosotros guardamos el contenido del ```HTML``` en el archivo ```htmlTexto.txt``` que se encuentra en el repositorio. \
   ![Imag6](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/count.png)

* __¿Cuál es la diferencia entre los verbos GET y POST?__
   * **GET** \
    El método GET  lleva una representación de un recurso específico que se encuentran almacenados en un servidor al usuarip. Las peticiones que usan el método GET sólo deben recuperar datos.
   * **POST:** \
    El método POST se utiliza para enviar una entidad a un recurso en específico, causando a menudo un cambio en el estado o efectos secundarios en el servidor.
   * **Diferencias:**  \
    El método GET lleva los datos usando la URL de forma visible, el método POST los envía de forma que no podemos verlos (en un segundo plano u "ocultos" al usuario)
    
* __¿Qué otros tipos de peticiones existen?__  \
    ![Imag7](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/operations.png)

6. En la practica no se utiliza ```telnet``` para hacer peticiones a sitios web sino el comando ```curl``` con ayuda de la linea de comandos:
```
curl www.httpbin.org
```
![Imag8](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/curl.png) 
El onjetivo de curl es transferir datos, sin interacción del usuario, hacia o desde un servidor.

Utilice ahora el parámetro -v:
```
curl www.httpbin.org -v
```
![Imag9](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/curl-v.png) 

Utilice ahora el parámetro -i:
```
curl www.httpbin.org -i
```
![Imag10](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/curl-i.png)
* __¿Cuáles son las diferencias con los diferentes parámetros?__ \
   * El ```-v``` hace que la operación sea más detallada 
   * El ```-i``` hace que incluya en las cabeceras de respuesta el protocolo responsable de la salida
 

### __Parte II. - Haciendo una aplicación Web dinámica a bajo nivel.__
En este ejercicio, va a implementar una aplicación Web muy básica, haciendo uso de los elementos de más bajo nivel de Java-EE (Enterprise Edition), con el fin de revisar los conceptos del protocolo HTTP. En este caso, se trata de un módulo de consulta de clientes Web que hace uso de una librería de acceso a datos disponible en un repositorio Maven local.
1. Revise la clase SampleServlet incluida a continuacion, e identifique qué hace: \
    **Servlet:** Los servlets son modulos java que nos sirven para extender las capacidades de los servidores web. 
2. Revise en el pom.xml para qué puerto TCP/IP está configurado el servidor embebido de Tomcat (ver sección de plugins): \
    El servidor se encuentra configurado para el puerto ***8080***
3. Compile y ejecute la aplicación en el servidor embebido Tomcat, a través de Maven con:
   ```
   mvn package
   mvn tomcat7:run
   ```
   como resultado se tiene \
   ![Imag11](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/CompilingTomCat.png)
4. Abra un navegador, y en la barra de direcciones ponga la URL con la cual se le enviarán peticiones al ‘SampleServlet’. Tenga en cuenta que la URL tendrá como host ‘localhost’, como puerto, el configurado en el pom.xml y el path debe ser el del Servlet. Debería obtener un mensaje de saludo. \
   ![Imag12](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/SampleServlet.png)
5. Observe que el Servlet ‘SampleServlet’ acepta peticiones GET, y opcionalmente, lee el parámetro ‘name’. Ingrese la misma URL, pero ahora agregando un parámetro GET (si no sabe como hacerlo, revise la documentación en <http://www.w3schools.com/tags/ref_httpmethods.asp> \
   ![Imag13](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/SampleServletParamterName.png)

### __Bibliografia__
* <https://developer.mozilla.org/es/docs/Web/HTTP/Methods>
* <https://es.stackoverflow.com/questions/34904/cuando-debo-usar-los-m%C3%A9todos-post-y-get>
* <http://www.manualweb.net/javaee/introduccion-servlets/>
* <http://www.w3schools.com/tags/ref_httpmethods.asp>
### __Autores__

* Camilo Rincón [Rincon10](https://github.com/Rincon10)
* Leonardo Galeano [Ersocaut](https://github.com/Ersocaut)