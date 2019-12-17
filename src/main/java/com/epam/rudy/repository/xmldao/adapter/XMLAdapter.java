package com.epam.rudy.repository.xmldao.adapter;

public interface XMLAdapter<X, O> {

	X toXML(O object);

	O toObject(X xml);
}
