/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.koala.view.data;

import io.koala.domain.Car;
import io.koala.service.CarService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class DataListView implements Serializable {

	private List<Car> cars1;

	private List<Car> cars2;

	private List<Car> cars3;

	private Car selectedCar;

//	@ManagedProperty("#{carService}")
	private CarService service;

	@Inject
	public DataListView(CarService service) {
		this.service = service;
	}

	@PostConstruct
	public void init() {
		cars1 = service.createCars(10);
		cars2 = service.createCars(5);
		cars3 = service.createCars(50);
	}

	public List<Car> getCars1() {
		return cars1;
	}

	public List<Car> getCars2() {
		return cars2;
	}

	public List<Car> getCars3() {
		return cars3;
	}

	public void setService(CarService service) {
		this.service = service;
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}
}
