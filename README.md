# Laboratorio-04
Laboratorio de moviles 04

# 1. Menciona los tipos de intents que existen y un ejemplo de cada uno

**Intents explícitos:** se utilizan para iniciar una actividad específica dentro de tu propia aplicación. En otras palabras, un intent explícito se utiliza para iniciar una actividad específica de tu aplicación mediante su nombre de clase.

```kotlin 
  //ejemplo de Intent explícito
   val intent = Intent(this, ShareActivity::class.java)
            intent.putExtra("name", nameEditText.text.toString())
            intent.putExtra("email", emailEditText.text.toString())
            intent.putExtra("phone", phoneEditText.text.toString())
            startActivity(intent)
```            

**Intents implícitos:** se utilizan para realizar una acción en la plataforma Android que no está dentro de tu propia aplicación. Por ejemplo, puedes utilizar un intent implícito para compartir contenido con otras aplicaciones, como compartir una imagen con una aplicación de redes sociales.

```kotlin 
  //ejemplo de Intent implícito
   val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Nombre: ${name} Correo Electrónico: ${email} Número de teléfono: ${phone}")
            }
            startActivity(Intent.createChooser(intent, "Compartir con"))
```            

# 2. En qué estado de la aplicación se inicializan las variables y se crea la vista

En Android, las variables se inicializan y la vista se crea en el método onCreate(), que se llama una vez cuando la actividad se está creando por primera vez.
