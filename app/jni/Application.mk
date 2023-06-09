
# Uncomment this if you're using STL in your project
# You can find more information here:
# https://developer.android.com/ndk/guides/cpp-support
APP_STL := c++_shared

APP_ABI :=  arm64-v8a #armeabi-v7a # x86 x86_64

# Min runtime API level
APP_PLATFORM=android-24

APP_ALLOW_MISSING_DEPS=true

APP_CPPFLAGS += -fexceptions
APP_CPPFLAGS += -frtti
APP_CPPFLAGS += -std=c++11 -v

