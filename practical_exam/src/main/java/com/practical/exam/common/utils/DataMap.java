package com.practical.exam.common.utils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

public class DataMap extends HashMap<String, Object> {
	
	private static final long serialVersionUID = -8659886474087835144L;

	/**
	 * 
	 * 해당 Key의 Value 값을 String 형태로 반환
	 * 
	 * @param key
	 * @return String
	 * @throws Exception
	 */
	public String getString(String key) {
		Object object = super.get(key);
		Object ob = new Object();
		String result;
		if (object != null) {
			if (object.getClass().isArray()) {
				// result = String.valueOf(((Object[])object)[0]).trim();
				ob = ((Object[]) object)[0];
				result = ob.toString();
				return result.trim();
			} else {
				// result = String.valueOf(object).trim();
				result = object.toString();
				return result.trim();
			}
		} else {
			return "";
		}
	}


	/**
	 * 
	 * 해당 Key의 Value 값을 String[] 형태로 반환
	 * 
	 * @param key
	 * @return String[]
	 * @throws Exception
	 */
	public String[] getStringArr(String key) {
		Object object = super.get(key);
		String result = null;
		if (object != null) {
			if (object.getClass().isArray()) {
				return (String[]) object;
			} else {
				result = object.toString().trim();
				return new String[] { result };
			}
		} else {
			return null;
		}
	}

	/**
	 *
	 * 해당 Key의 Value 값을 int 형태로 반환
	 * 
	 * @param key
	 * @return int
	 */
	public int getInt(String key) {
		Object object = super.get(key);
		if (object == null) {
			return 0;
		}

		int result = -1;
		if (object instanceof String) {
			String str = ((String) object).trim();
			result = str.isEmpty() ? 0 : Integer.parseInt(str);
		} else if (object instanceof Number) {
			result = ((Number) object).intValue();
		} else if (object instanceof java.sql.Timestamp) {
			result = (int) ((java.sql.Timestamp) object).getTime();
		}
		return result;
	}

	/**
	 * 
	 *  해당 Key의 Value 값을 long 형태로 반환
	 * 
	 * @param key
	 * @return long 
	 */
	public long getLong(String key) {
		Object obj = super.get(key);
		if (obj == null) {
			return 0;
		}

		if (obj instanceof Number) {
			return ((Number) obj).longValue();
		} else if (obj instanceof java.sql.Timestamp) {
			return ((java.sql.Timestamp) obj).getTime();
		} else if (obj instanceof String) {
			return Long.parseLong((String) obj);
		}
		return 0;
	}

	/**
	 * 
	 *  해당 Key의 Value 값을 double 형태로 반환
	 * 
	 * @param key
	 * @return double
	 */
	public double getDouble(String key) {
		Object obj = super.get(key);
		if (obj == null) {
			return 0;
		}

		if (obj instanceof Number) {
			return ((Number) obj).doubleValue();
		} else if (obj instanceof java.sql.Timestamp) {
			return ((java.sql.Timestamp) obj).getTime();
		} else if (obj instanceof String) {
			return Double.parseDouble((String) obj);
		}
		return 0;
	}

	/**
	 * 
	 * 해당 Key의 Date Value를 반환
	 * 
	 * @param key
	 * @return Date Value
	 * @throws Exception
	 */
	public Date getDate(String key) {
		return (Date) (super.get(key));
	}

	public boolean getBoolean(String key) {
		String val = getString(key);
		if (val.isEmpty()) {
			return false;
		}
		return (val.equalsIgnoreCase("true"));
	}

	/**
	 * 
	 * 해당 Key의 Object Value를 반환
	 * 
	 * @param key
	 * @return Object Value
	 * @throws Exception
	 */
	public Object getObject(String key) {
		return super.get(key);
	}

	/**
	 * 
	 * 해당 Key의 byte Value를 반환
	 * 
	 * @param key
	 * @return byte
	 * @throws Exception
	 * @throws IOException
	 */
	public byte[] getBinary(String key) {
		return (byte[]) (super.get(key));
	}


	/**
	 * 
	 * 해당 Key의 Object Value를 기입.
	 * 
	 * @param key
	 * @param value
	 * @throws Exception
	 */
	public void set(String key, Object value) {
		if (key == null || value == null) {
			return;
		}
		this.put(key, value);
	}

}
