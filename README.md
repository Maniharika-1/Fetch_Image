# Fetch_Image

Brief Introduction:
This is an app which contains a button on the home screen and when the button is clicked, it will move to another page where on requesting, an image is displayed.

Detailed Explanation:
Four intents are created. Each intent contains a button which on clicking fetches an image from a URL and displays it on the ImageView. For fetching/downloading the image from
the URL, a class called ImageDownloader is created. This class extends the AsyncTask class which is an abstract class and is used to perform long-lasting tasks in the background
and show the result on the UI thread without affecting the main thread i.e. here the image is downloaded in the background thread. The ImageDownloader class overrides the doInBackground(String... strings) method. It takes a String of URLs 
as input and gives Bitmap object as output. An HttpURLConnection is opened and connected. The Bitmap object is created by decoding the InputStream of the URL connection. This object
is returned to the onClick method of the Button from where the execution/image fetching request was made. The resulting bitmap image is set in the ImageView.
In MainActivity.java, a number between 0-3 is generated randomly using random generator and call is made to each intent according to this random number.

The code for presentation logic is written in XML and the code for business logic is written in Java.
