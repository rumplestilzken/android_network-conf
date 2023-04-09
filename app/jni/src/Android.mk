LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := network-conf

#LOCAL_C_INCLUDES := $(LOCAL_PATH)/$(SDL_PATH)/include \
#					$(LOCAL_PATH)/$(SDL_IMAGE_PATH) \
#					$(LOCAL_PATH)/$(SDL_MIXER_PATH)/include \
#  				 	$(LOCAL_PATH)/$(SDL_TTF_PATH) \
# 					$(LOCAL_PATH)/$(PROTO_BUFFER_PATH)/

# Add your application source files here...
LOCAL_SRC_FILES := Network-Conf.cpp

#LOCAL_STATIC_LIBRARIES := beast_hacker #android

LOCAL_SHARED_LIBRARIES :=# android

LOCAL_LDLIBS := -llog -landroid

LOCAL_CPPFLAGS :=

include $(BUILD_SHARED_LIBRARY)
