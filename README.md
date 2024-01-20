# Marvel Android App

Welcome to the Marvel Android App! In order to run the app successfully, you'll need to obtain API keys from the Marvel Developer Portal and set them up in your local project. Here's a step-by-step guide:

### Step 1: Clone the Repository

Clone the repository to your local machine:

```
git clone https://github.com/MatejStrlek/MarvelApp_Android.git
cd MarvelApp_Android
```

### Step 2: Obtain Marvel API Keys

1. Visit the [Marvel Developer Portal](https://developer.marvel.com).
2. Log in or create a new account.
3. Once logged in, navigate to the "My Account" section.
4. In the "API Keys" tab, you'll find both your Public Key and Private Key.

### Step 3: Set up Local Properties

1. In the root directory of the project, create a file named local.properties.
2. Add the following lines to local.properties:

```
marvel.publicKey="your_marvel_public_key"
marvel.privateKey="your_marvel_private_key"
```

Replace "your_marvel_public_key" and "your_marvel_private_key" with the keys obtained from the Marvel Developer Portal.

### Step 4: Build and Run the App

Now that you've set up your API keys, you're ready to build and run the app. Open the project in Android Studio and proceed with the build process.

### Note:

**Keep your API keys confidential**: Do not share your API keys in public repositories or forums. The 'local.properties' file is listed in the project's .gitignore file to prevent accidental exposure.

**Secure your keys in production**: If you plan to release the app, consider using a more secure approach for handling API keys in a production environment.

<br /><br />
If you encounter any issues or have questions, feel free to contact me :)

<br /><br />
## Details about app

This repository contains the source code for a mobile app development project focused on creating a feature-rich and visually appealing Android application. The project encompasses various aspects, including:

**Multilingual Support**: Explore the architecture of the mobile ecosystem, implement best practices for creating multilingual applications compatible across different devices.

**Advanced UI Elements**: Enhance the app's visual appeal using advanced graphical interface elements, following Material Design principles. Utilize RecyclerView, Adapter, CardView, and ViewPager for scalability.

**Architectural Components**: Implement and detail the usage of standard architectural components, such as Activity lifecycle management, explicit and implicit Intents, and the integration of menus, dialogs, and settings.

**Persistent Data Management**: Establish robust data storage and management using SQLite databases, SQLiteOpenHelper, SharedPreferences, and ContentProvider components.

**Services and Background Processing**: Leverage system services, BroadcastReceivers, Services, and Workers for notification handling, background execution, and efficient data retrieval from the internet.

**Security Measures**: Implement various levels of security, including obfuscation, unique application keys, and permissions. Explore and detail the configuration of code protection.

This project showcases a comprehensive approach to mobile app development, covering both fundamental and advanced concepts. Feel free to explore the code and documentation for a deeper understanding.

Happy coding! 🚀
