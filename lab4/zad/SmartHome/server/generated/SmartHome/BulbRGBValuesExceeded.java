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

public class BulbRGBValuesExceeded extends com.zeroc.Ice.UserException
{
    public BulbRGBValuesExceeded()
    {
    }

    public BulbRGBValuesExceeded(Throwable cause)
    {
        super(cause);
    }

    public String ice_id()
    {
        return "::SmartHome::BulbRGBValuesExceeded";
    }

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::SmartHome::BulbRGBValuesExceeded", -1, true);
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
    public static final long serialVersionUID = 9082486988767063772L;
}
