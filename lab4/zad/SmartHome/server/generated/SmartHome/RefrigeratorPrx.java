//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.9
//
// <auto-generated>
//
// Generated from file `smart_home.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SmartHome;

public interface RefrigeratorPrx extends com.zeroc.Ice.ObjectPrx
{
    default void powerOn()
        throws RefrigeratorIsAlreadyOn
    {
        powerOn(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void powerOn(java.util.Map<String, String> context)
        throws RefrigeratorIsAlreadyOn
    {
        try
        {
            _iceI_powerOnAsync(context, true).waitForResponseOrUserEx();
        }
        catch(RefrigeratorIsAlreadyOn ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> powerOnAsync()
    {
        return _iceI_powerOnAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> powerOnAsync(java.util.Map<String, String> context)
    {
        return _iceI_powerOnAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_powerOnAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "powerOn", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_powerOn);
        f.invoke(true, context, null, null, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_powerOn =
    {
        RefrigeratorIsAlreadyOn.class
    };

    default void powerOff()
        throws RefrigeratorIsSwitchedOff
    {
        powerOff(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void powerOff(java.util.Map<String, String> context)
        throws RefrigeratorIsSwitchedOff
    {
        try
        {
            _iceI_powerOffAsync(context, true).waitForResponseOrUserEx();
        }
        catch(RefrigeratorIsSwitchedOff ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> powerOffAsync()
    {
        return _iceI_powerOffAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> powerOffAsync(java.util.Map<String, String> context)
    {
        return _iceI_powerOffAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_powerOffAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "powerOff", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_powerOff);
        f.invoke(true, context, null, null, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_powerOff =
    {
        RefrigeratorIsSwitchedOff.class
    };

    default RefrigeratorParams getParams()
    {
        return getParams(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default RefrigeratorParams getParams(java.util.Map<String, String> context)
    {
        return _iceI_getParamsAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<RefrigeratorParams> getParamsAsync()
    {
        return _iceI_getParamsAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<RefrigeratorParams> getParamsAsync(java.util.Map<String, String> context)
    {
        return _iceI_getParamsAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<RefrigeratorParams> _iceI_getParamsAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<RefrigeratorParams> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getParams", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     final com.zeroc.IceInternal.Holder<RefrigeratorParams> ret = new com.zeroc.IceInternal.Holder<>();
                     istr.readValue(v -> ret.value = v, RefrigeratorParams.class);
                     istr.readPendingValues();
                     return ret.value;
                 });
        return f;
    }

    default RefrigeratorSettings getSettings()
    {
        return getSettings(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default RefrigeratorSettings getSettings(java.util.Map<String, String> context)
    {
        return _iceI_getSettingsAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<RefrigeratorSettings> getSettingsAsync()
    {
        return _iceI_getSettingsAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<RefrigeratorSettings> getSettingsAsync(java.util.Map<String, String> context)
    {
        return _iceI_getSettingsAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<RefrigeratorSettings> _iceI_getSettingsAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<RefrigeratorSettings> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getSettings", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     final com.zeroc.IceInternal.Holder<RefrigeratorSettings> ret = new com.zeroc.IceInternal.Holder<>();
                     istr.readValue(v -> ret.value = v, RefrigeratorSettings.class);
                     istr.readPendingValues();
                     return ret.value;
                 });
        return f;
    }

    default RefrigeratorSensors[] getSensorValues()
        throws RefrigeratorIsSwitchedOff
    {
        return getSensorValues(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default RefrigeratorSensors[] getSensorValues(java.util.Map<String, String> context)
        throws RefrigeratorIsSwitchedOff
    {
        try
        {
            return _iceI_getSensorValuesAsync(context, true).waitForResponseOrUserEx();
        }
        catch(RefrigeratorIsSwitchedOff ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<RefrigeratorSensors[]> getSensorValuesAsync()
    {
        return _iceI_getSensorValuesAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<RefrigeratorSensors[]> getSensorValuesAsync(java.util.Map<String, String> context)
    {
        return _iceI_getSensorValuesAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<RefrigeratorSensors[]> _iceI_getSensorValuesAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<RefrigeratorSensors[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getSensorValues", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_getSensorValues);
        f.invoke(true, context, null, null, istr -> {
                     RefrigeratorSensors[] ret;
                     ret = RefrigeratorSensorsSequenceHelper.read(istr);
                     istr.readPendingValues();
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_getSensorValues =
    {
        RefrigeratorIsSwitchedOff.class
    };

    default void setRefrigeratorTargetTemperature(float tmp)
        throws RefrigeratorIsSwitchedOff,
               RefrigeratorTargetTemperatureOutOffRange
    {
        setRefrigeratorTargetTemperature(tmp, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void setRefrigeratorTargetTemperature(float tmp, java.util.Map<String, String> context)
        throws RefrigeratorIsSwitchedOff,
               RefrigeratorTargetTemperatureOutOffRange
    {
        try
        {
            _iceI_setRefrigeratorTargetTemperatureAsync(tmp, context, true).waitForResponseOrUserEx();
        }
        catch(RefrigeratorIsSwitchedOff ex)
        {
            throw ex;
        }
        catch(RefrigeratorTargetTemperatureOutOffRange ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> setRefrigeratorTargetTemperatureAsync(float tmp)
    {
        return _iceI_setRefrigeratorTargetTemperatureAsync(tmp, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> setRefrigeratorTargetTemperatureAsync(float tmp, java.util.Map<String, String> context)
    {
        return _iceI_setRefrigeratorTargetTemperatureAsync(tmp, context, false);
    }

    /**
     * @hidden
     * @param iceP_tmp -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_setRefrigeratorTargetTemperatureAsync(float iceP_tmp, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "setRefrigeratorTargetTemperature", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_setRefrigeratorTargetTemperature);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeFloat(iceP_tmp);
                 }, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_setRefrigeratorTargetTemperature =
    {
        RefrigeratorIsSwitchedOff.class,
        RefrigeratorTargetTemperatureOutOffRange.class
    };

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static RefrigeratorPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), RefrigeratorPrx.class, _RefrigeratorPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static RefrigeratorPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), RefrigeratorPrx.class, _RefrigeratorPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static RefrigeratorPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), RefrigeratorPrx.class, _RefrigeratorPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static RefrigeratorPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), RefrigeratorPrx.class, _RefrigeratorPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static RefrigeratorPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, RefrigeratorPrx.class, _RefrigeratorPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static RefrigeratorPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, RefrigeratorPrx.class, _RefrigeratorPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default RefrigeratorPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (RefrigeratorPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default RefrigeratorPrx ice_adapterId(String newAdapterId)
    {
        return (RefrigeratorPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default RefrigeratorPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (RefrigeratorPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default RefrigeratorPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (RefrigeratorPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default RefrigeratorPrx ice_invocationTimeout(int newTimeout)
    {
        return (RefrigeratorPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default RefrigeratorPrx ice_connectionCached(boolean newCache)
    {
        return (RefrigeratorPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default RefrigeratorPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (RefrigeratorPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default RefrigeratorPrx ice_secure(boolean b)
    {
        return (RefrigeratorPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default RefrigeratorPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (RefrigeratorPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default RefrigeratorPrx ice_preferSecure(boolean b)
    {
        return (RefrigeratorPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default RefrigeratorPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (RefrigeratorPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default RefrigeratorPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (RefrigeratorPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default RefrigeratorPrx ice_collocationOptimized(boolean b)
    {
        return (RefrigeratorPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default RefrigeratorPrx ice_twoway()
    {
        return (RefrigeratorPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default RefrigeratorPrx ice_oneway()
    {
        return (RefrigeratorPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default RefrigeratorPrx ice_batchOneway()
    {
        return (RefrigeratorPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default RefrigeratorPrx ice_datagram()
    {
        return (RefrigeratorPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default RefrigeratorPrx ice_batchDatagram()
    {
        return (RefrigeratorPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default RefrigeratorPrx ice_compress(boolean co)
    {
        return (RefrigeratorPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default RefrigeratorPrx ice_timeout(int t)
    {
        return (RefrigeratorPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default RefrigeratorPrx ice_connectionId(String connectionId)
    {
        return (RefrigeratorPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default RefrigeratorPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (RefrigeratorPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::SmartHome::Refrigerator";
    }
}
