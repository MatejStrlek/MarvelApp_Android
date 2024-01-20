# Marvel Android App

Welcome to the Marvel Android App! In order to run the app successfully, you'll need to obtain API keys from the Marvel Developer Portal and set them up in your local project. Here's a step-by-step guide:

### Step 1: Clone the Repository

Clone the repository to your local machine:

```
git clone https://github.com/MatejStrlek/MarvelApp_Android.git
cd marvel-android-app
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

Replace your_marvel_public_key and your_marvel_private_key with the keys obtained from the Marvel Developer Portal.

### Step 4: Build and Run the App

Now that you've set up your API keys, you're ready to build and run the app. Open the project in Android Studio and proceed with the build process.

### Note:

**Keep your API keys confidential**: Do not share your API keys in public repositories or forums. The 'local.properties' file is listed in the project's .gitignore file to prevent accidental exposure.

**Secure your keys in production**: If you plan to release the app, consider using a more secure approach for handling API keys in a production environment.

<br /><br />
If you encounter any issues or have questions, feel free to contact me :)

Happy coding!
