package com.example.mentorship.model;

public enum EHairCut {

	TUNS("tuns") {
		@Override
		public double getDuration() {
			return 2;
		}
	},
	SPALAT("spalat") {
		@Override
		public double getDuration() {
			return 0.5;
		}
	},
	FREZA("freza") {
		@Override
		public double getDuration() {
			return 1;
		}
	},

	VOPSIT("vopsit") {

		@Override
		public double getDuration() {
			return 3;
		}

	};

	private String description;

	EHairCut(String description) {
		this.description = description;
	}

	public String getDesctiption() {
		return description;
	}

	public abstract double getDuration();

}
