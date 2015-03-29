package net.bytebuddy.test.precompiled;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class ParameterBootstrap {

    private static final String FOO = "foo";

    public static Object[] arguments;

    public static CallSite bootstrapArrayArguments(MethodHandles.Lookup lookup,
                                                   String methodName,
                                                   MethodType methodType,
                                                   Object... arguments)
            throws NoSuchMethodException, IllegalAccessException {
        ParameterBootstrap.arguments = arguments;
        return new ConstantCallSite(lookup.findStatic(ParameterBootstrap.class, methodName, methodType));
    }

    public static CallSite bootstrapExplicitArguments(MethodHandles.Lookup lookup,
                                                      String methodName,
                                                      MethodType methodType,
                                                      int arg0,
                                                      long arg1,
                                                      float arg2,
                                                      double arg3,
                                                      String arg4,
                                                      Class<?> arg5)
            throws NoSuchMethodException, IllegalAccessException {
        ParameterBootstrap.arguments = new Object[]{arg0, arg1, arg2, arg3, arg4, arg5};
        return new ConstantCallSite(lookup.findStatic(ParameterBootstrap.class, methodName, methodType));
    }

    public static String foo() {
        return FOO;
    }
}
