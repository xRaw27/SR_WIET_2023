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

public class BulbCannotSetBrightnessInAutoMode extends com.zeroc.Ice.UserException
{
    public BulbCannotSetBrightnessInAutoMode()
    {
    }

    public BulbCannotSetBrightnessInAutoMode(Throwable cause)
    {
        super(cause);
    }

    public String ice_id()
    {
        return "::SmartHome::BulbCannotSetBrightnessInAutoMode";
    }

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::SmartHome::BulbCannotSetBrightnessInAutoMode", -1, true);
        ostr_.endSlice();
    }

    /** @hidden */
    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        istr_.endSlice();
    }

    /** @hidden */
    public static final long serialVersionUID = -662543978888560239L;
}
