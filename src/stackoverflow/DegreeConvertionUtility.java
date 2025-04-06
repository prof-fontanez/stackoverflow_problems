package stackoverflow;

public final class DegreeConvertionUtility {
    public enum Scale {
      Celsius, Fahrenheit, Kelvin
    }

    private final double temperature;

    private DegreeConvertionUtility(double temperature) {
      this.temperature = temperature;
    }

    public static DegreeConvertionUtility create(double temperature, Scale scale) {
      switch (scale) {
        case Celsius:
          return new DegreeConvertionUtility(temperature + 273.15);
        case Fahrenheit:
          return new DegreeConvertionUtility((temperature + 459.67) * 5.0 / 9.0);
        case Kelvin:
          return new DegreeConvertionUtility(temperature);
        default:
          throw new IllegalArgumentException("Unknown scale");
      }
    }

    public double convertTo(Scale scale) {
      switch (scale) {
        case Celsius:
          return temperature - 273.15;
        case Fahrenheit:
          return temperature * 9.0 / 5.0 - 459.67;
        case Kelvin:
          return temperature;
        default:
          throw new IllegalArgumentException("Unknown scale");
      }
    }
  }