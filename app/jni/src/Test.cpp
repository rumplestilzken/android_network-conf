#include <jni.h>
#include <string>
#include <stdio.h>
#include <cstdio>
#include <iostream>
#include <memory>
#include <stdexcept>
#include <array>

std::string exec(const char* cmd) {
    std::array<char, 128> buffer;
    std::string result;
    std::unique_ptr<FILE, decltype(&pclose)> pipe(popen(cmd, "r"), pclose);
    if (!pipe) {
        throw std::runtime_error("popen() failed!");
    }
    while (fgets(buffer.data(), buffer.size(), pipe.get()) != nullptr) {
        result += buffer.data();
    }
    return result;
}

extern "C" {

JNIEXPORT jstring Java_com_rumplestilzken_shell_ShellCommandProcessor_ping(JNIEnv *env, jobject thiz, jint count,
                                                         jstring address) {
    const char *nativeString = env->GetStringUTFChars(address, 0);

    char buf[25];
    snprintf(buf, 20, "ping -c %d ", count);
    strcat(buf, nativeString);

//    std::stringstream ss;
//    ss << "ping -c " << count << " " << nativeString;
    std::string res = exec(buf);

    env->ReleaseStringUTFChars(address, nativeString);

    return env->NewStringUTF(res.c_str());
}

}

