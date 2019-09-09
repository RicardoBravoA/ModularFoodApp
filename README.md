
# ModularFoodApp

Proyecto de ejemplo utilizando **Kotlin**, **Android Libraries** y **Dinamyc Features** <br>

## Requerimientos

El proyecto funciona desde **Android 5+ (API 21+)**<br>

## Arquitectura

- Se está utilizando **Clean Architecture** y **MVVM** para la capa de presentación
- Se utilizaron: **Android Libraries**, **Application** y **Dynamic Feature**

![Architecture Image](image/architecture.png)

## Uso 

- Splash <br>
    - Se encuentra en **app**
    - Abre la actividad **MapActivity** que se encuentra en el módulo **map**

<p align="center">
  <img src="image/img1.jpg" alt="Splash" width="303" height="640"/>
</p>


- Permiso de GPS<br>
    - Se encuentra en **map**
    - Utiliza Google Maps
    - Solicita permiso de GPS
    - Solicita encender el GPS

<p align="center">
  <img src="image/img2.jpg" alt="GPS Permission" width="303" height="640"/><br><br>
    <img src="image/img3.jpg" alt="Activate GPS" width="303" height="640"/><br>
</p>

- Mapa<br>
    - Se encuentra en **map**
    - Abre la actividad **DetailActivity** que se encuentra en el módulo **detail**
    - Utiliza Google Maps
    - Muestra un listado horizontal de los restuarantes que se encuentran cerca de la ubicación del usuario
    - En este caso, para **Perú** no hay información

<p align="center">
  <img src="image/img4.jpg" alt="Map" width="303" height="640"/><br>
</p>

- Moviendo el mapa hacia New York (si tiene data)<br>
    - Al mover el mapa, aparece un botón **Search in this area** para obtener las coordenadas del centro 
    de la pantalla y realizar una búsqueda, aunque sería mejor obtener las coordenadas de la parte 
    superior e inferior de la pantalla para realizar una búsqueda en toda el área y tener clusters 
    - Permite mover el mapa hacia una ubicación donde si existe data, por ejemplo: New York
    - Los resultados se muestran en la parte inferior del mapa
    - Los resultados tiene scroll horizontal

<p align="center">
  <img src="image/img5.jpg" alt="Move to New York" width="303" height="640"/><br>
</p>

- Seleccionando un marcador<br>
    - Al seleccionar un marcador, aparece su nombre en la parte superior y en el resultado de la 
    parte inferior se muestra visible la información de dicha selección

<p align="center">
  <img src="image/img6.jpg" alt="Select a marker" width="303" height="640"/><br>
</p>

- Buscando un restaurant en el listado<br>
    - Al hacer scroll en el listado, también se muestra en el centro de la pantalla el marcador

<p align="center">
  <img src="image/img7.jpg" alt="Move restaurants list" width="303" height="640"/><br>
</p>

- Detalle **(in progress)** <br>
    - **Pantalla sin diseño** que muestra poca información del servicio

<p align="center">
  <img src="image/img8.jpg" alt="Detail" width="303" height="640"/><br>
</p>

## Unit Test

Se hicieron tests para los módulos **mapdata** y **detaildata**, teniendo una cobertura de 100% en ambos módulos

<p align="center">
  <img src="image/img9.png" alt="Move restaurants list" width="359" height="204"/><br>
</p>

## APK

Se encuentra [aquí](apk/)

  <br>  
  <br>  
*Happy coding!*