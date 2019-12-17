package com.epam.rudy.repository;

import java.util.List;

public interface SimpleDAO<T> {

	void save(List<T> objects);

	List<T> read();
}
