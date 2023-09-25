# flutter 3.0

major update news

- window, linux, macOS stable support

> *deprecate window 7/8*

- support foldable phone (mobile)

- ios release by command

``` ternimal
$flutter build ipa
```

- gradle version update 

7.1.2(AGP) 7.4(gradle)

- Material 3 system 
- Theme extensions
    MaterialApp Theme 에 custom color를 적용가능

    ``` dart
    @override
    Widget build(BuildContext context) {
        return MaterialApp(
            theme: ThemeData.light().copyWith(
                extensions: <ThemeExtension<dynamic>>[
                    const MyColors(
                        brandColor: Color(0xFF1E88E5),
                        danger: Color(0xFFE53935),
                    ),
                ],
            ),
            darkTheme: ThemeData.dark().copyWith(
                extensions: <ThemeExtension<dynamic>>[
                    const MyColors(
                    brandColor: Color(0xFF90CAF9),
                    danger: Color(0xFFEF9A9A),
                    ),
                ],
            ),
            themeMode: isLightTheme ? ThemeMode.light : ThemeMode.dark,
            home: Home(
                isLightTheme: isLightTheme,
                toggleTheme: toggleTheme,
            ),
        );
    }

    class Home extends StatelessWidget {
        ...

        @override
        Widget build(BuildContext context) {
            final MyColors myColors = Theme.of(context).extension<MyColors>()!;
            ...
        }
    }
    ```

- Ads

- breaking changes
    1. TextField maxLengthEnforced deprecated
    2. VelocityTracker  default constructor deprecated
    3. DayPicker & MonthPicker deprecated -> MaterialDatePicker redesigned
    4. Flat, Raised, Outline Button deprecated (Material design 영향인듯?)
    5. Scaffold SnackBar deprecated
        ``` dart
        // deprecated
        Scaffold.of(context).showSnackBar(mySnackBar);
        Scaffold.of(context).removeCurrentSnackBar(mySnackBar);
        Scaffold.of(context).hideCurrentSnackBar(mySnackBar);

        // updated
        ScaffoldMessenger.of(context).showSnackBar(mySnackBar);
        ScaffoldMessenger.of(context).removeCurrentSnackBar(mySnackBar);
        ScaffoldMessenger.of(context).hideCurrentSnackBar(mySnackBar);
        ```
    6. RectangularSliderTrackShape.disabledThumbGapWidth deprecated
        ``` dart
        // deprecated
        RectangularSliderTrackShape(disabledThumbGapWidth: 2.0);

        // updated
        RectangularSliderTrackShape();
        ```
    7. Text selection of ThemeData to TextSelectionThemeData
    8. RenderEditable.onSelectionChanged to TextSelectionDelegate.textEditingValue
    9. Stack.overflow deprecated
        ``` dart
            // deprecated
            const Stack stack = Stack(overflow: Overflow.visible);
            const Stack stack = Stack(overflow: Overflow.clip);

            // updated
            const Stack stack = Stack(clipBehavior: Clip.none);
            const Stack stack = Stack(clipBehavior: Clip.hardEdge);
        ```
    10. UpdateLiveRegionEvent : SemanticsEvent UpdateLiveRegionEvent deprecated
    11. RenderObjectElement methods
        ``` dart
            // deprecated
            element.insertChildRenderObject(child, slot);
            element.moveChildRenderObject(child, slot);
            element.removeChildRenderObject(child);

            // updated
            element.insertRenderObjectChild(child, slot);
            element.moveRenderObjectChild(child, oldSlot, newSlot);
            element.removeRenderObjectChild(child, slot);
        ```

# flutter 3.3

- graphics engine update
- eric이 떠남


# flutter 3.7

- Enhanced Material 3 support
> **New Materails**
> * Badge
> * BottomAppBar
> * Filled and Filled Tonal buttons
> * SegmentedButton
> * Checkbox
> * Divider
> * Menus
> * DropdownMenu
> * Drawer and NavigationDrawer
> * ProgressIndicator
> * Radio buttons
> * Slider
> * SnackBar
> * TabBar
> * TextFields and InputDecorator
> * Banner

> NOTE: **[Demo Page](https://flutter.github.io/samples/web/material_3_demo/)**

- DevTools updates: Profile, Trace, Diff 기능 제공

- Custom context menus: 이미지 long press 시 나오는 메뉴등을 custom 가능

- CupertinoListSection and CupertinoListTile widgets

- Scrolling improvements

    New AnimatedGrid and SliverAnimatedGrid widgets

- **Background isolates** : Now Platform Channels can be invoked from any Isolate

- Swift migration for plugins
- Bitcode deprecation
- iOS PlatformView BackdropFilter
- Memory management
- font asset hot reload
- iOS devices 에서 animation 버벅거림 감소

# Flutter 3.10 update

- Material3 Design 

- SLSA level 1 달성

* 지들 자랑인듯?..


## Mobile

**iOS**
1. [Wireless debugging](https://docs.flutter.dev/get-started/install/macos#ios-setup)

2. Wide gamut image support 

3. Spellcheck support

4. Adaptive checkbox and radio : cupertino library에 추가됨.

5. Refining Cupertino animations, transitions and colors
    > 몇몇 위젯을 swfitui 와 비슷하게 변경.

6. PlatformView performance
 
7. macOS and iOS can use shared code in plugins

8. New resources for app extensions

**Android**

1. Android CameraX support

**DevTools**

1. Material design 적용
2. evaluations for a running app in debug mode.
3. time-line viewer가  Perfetto trace viewer 로 변경됨


## Deprecations & Breaking Changes

- deprecated
    1. GestureRecognizer.kind  deprecated
    2. color theme 변경 Material design 반영 
    3. AppBar, SliverAppBar, and AppBarTheme updates
    4. SystemChrome.setEnabledSystemUIOverlays deprecated & SystemChrome.setEnabledSystemUIMode 로 변경됨
    5. SystemNavigator.routeUpdated depreacated
    6. AnimatedSize.vsync deprecated

- Android Studio Flamingo upgrade
    > *Guide* [flutter guide](https://docs.flutter.dev/release/breaking-changes/android-java-gradle-migration-guide)
- Window singleton deprecation
