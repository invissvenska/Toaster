# Toaster
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14) [![](https://jitpack.io/v/invissvenska/Toaster.svg)](https://jitpack.io/#invissvenska/Toaster)  

Based on [GrenderG Toasty](https://github.com/GrenderG/Toasty) but using AndroidX library and more options: positioning of the toast and material design

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.invissvenska:Toaster:1.0.1'
}
```

## Configuration

This step is optional, but if you want you can configure some Toaster parameters. Place this anywhere in your app:

```java
Toaster.Config.getInstance()
    .tintIcon(boolean tintIcon) // optional (apply textColor also to the icon)
    .setToastTypeface(@NonNull Typeface typeface) // optional
    .setTextSize(int sizeInSp) // optional
    .allowQueue(boolean allowQueue) // optional (prevents several Toasters from queuing)
    .setGravity(int gravity, int offsetX, int offsetY) // optional
    .setMargin(float horizontalMargin, float verticalMargin) // optional
    .setMaterial(boolean material) // optional
    .apply(); // required
```

You can reset the configuration by using `reset()` method:

```java
Toaster.Config.reset();
```

## Usage

Each method always returns a `Toast` object, so you can customize the Toast much more. **DON'T FORGET THE `show()` METHOD!**

To display an error Toast:

``` java
Toaster.error(yourContext, "This is an error toast.", Toast.LENGTH_SHORT, true).show();
```
To display a success Toast:

``` java
Toaster.success(yourContext, "Success!", Toast.LENGTH_SHORT, true).show();
```
To display an info Toast:

``` java
Toaster.info(yourContext, "Here is some info for you.", Toast.LENGTH_SHORT, true).show();
```
To display a warning Toast:

``` java
Toaster.warning(yourContext, "Beware of the dog.", Toast.LENGTH_SHORT, true).show();
```
To display the usual Toast:

``` java
Toaster.normal(yourContext, "Normal toast w/o icon").show();
```
To display the usual Toast with icon:

``` java
Toaster.normal(yourContext, "Normal toast w/ icon", yourIconDrawable).show();
```

You can also create your custom Toasts with the `custom()` method:
``` java
Toaster.custom(yourContext, "I'm a custom Toast", yourIconDrawable, tintColor, duration, withIcon, shouldTint).show();
```

## Screenshots

**Please click the image below to enlarge.**

<img src="https://raw.githubusercontent.com/invissvenska/Toaster/master/media/collage.png">