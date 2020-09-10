# __CVDS-LAB5__

## __Contributors__

> Camilo Rincón [Rincon10](https://github.com/Rincon10)
>
> Leonardo Galeano [Ersocaut](https://github.com/Ersocaut)

---

### Parte 1

Para poder ejecutar el comando ```telnet HOST PORT``` es necesario realizar la habilitación del mismo de la siguiente forma.

![](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/InstallTelnet.png)

Algunos de los errores que puede arrojar la ejecución de este comando son:

__Error 400: Bad request__: Indica que el sitio web o Host, no reconoce el comando o la solicitud del cliente porque esta no respeta el protocolo HTTP, por ende no la puede procesar.

![](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/Error400.png)

__Error 301: Moved permanently__: Indica que el host ha sido capaz de comunicarse con el servidor pero que el recurso solicitado ha sido movido a otra dirección permanentemente.

![](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/Error400.png)

__Solicitar el recurso /html__: Ejecutando el comando ```telnet www.httpbin.com 80```, y dentro del mismo solicitando ```GET /html HTTP/1.0``` se obtiene:

![](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/GEThttpbin.png)

...
