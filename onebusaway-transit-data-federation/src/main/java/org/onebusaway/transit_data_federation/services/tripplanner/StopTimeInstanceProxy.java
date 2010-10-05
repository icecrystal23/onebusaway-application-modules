package org.onebusaway.transit_data_federation.services.tripplanner;

import java.text.DateFormat;
import java.util.Date;

import org.onebusaway.gtfs.model.AgencyAndId;

public class StopTimeInstanceProxy {

  private static final DateFormat DAY_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

  private static final DateFormat TIME_FORMAT = DateFormat.getDateTimeInstance(
      DateFormat.SHORT, DateFormat.SHORT);

  private long _serviceDate;
  
  private AgencyAndId _vehicleId;

  private BlockStopTimeEntry _stopTime;

  /*
  private boolean _predicted = false;

  private long lastUpdateTime;

  private boolean _hasPredictedArrivalOffset = false;

  private boolean _hasPredictedDepartureOffset = false;

  private int _predictedArrivalOffset = 0;

  private int _predictedDepartureOffset = 0;

  private double _distanceFromStop = Double.NaN;
  
  private int _numberOfStopsAway;
  */

  public StopTimeInstanceProxy(BlockStopTimeEntry stopTime, Date serviceDate) {
    this(stopTime, serviceDate.getTime());
  }

  public StopTimeInstanceProxy(BlockStopTimeEntry stopTime, long serviceDate) {
    _stopTime = stopTime;
    _serviceDate = serviceDate;
  }

  public BlockStopTimeEntry getStopTime() {
    return _stopTime;
  }

  public BlockTripEntry getTrip() {
    return _stopTime.getTrip();
  }

  public int getSequence() {
    return _stopTime.getBlockSequence();
  }

  public StopEntry getStop() {
    return _stopTime.getStopTime().getStop();
  }

  public long getServiceDate() {
    return _serviceDate;
  }

  public long getArrivalTime() {
    return _serviceDate + _stopTime.getStopTime().getArrivalTime() * 1000;
  }

  public long getDepartureTime() {
    return _serviceDate + _stopTime.getStopTime().getDepartureTime() * 1000;
  }
  
  public AgencyAndId getVehicleId() {
    return _vehicleId;
  }
  
  public void setVehicleId(AgencyAndId vehicleId) {
    _vehicleId = vehicleId;
  }

  /*
  public boolean isPredicted() {
    return _predicted;
  }

  public void setPredicted(boolean predicted) {
    _predicted = predicted;
  }

  public long getLastUpdateTime() {
    return lastUpdateTime;
  }

  public void setLastUpdateTime(long lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

  public boolean hasPredictedArrivalOffset() {
    return _hasPredictedArrivalOffset;
  }
  */

  /**
   * Set the predicted arrival offset, in seconds. The predicted arrival time
   * offset is additive, which means a positive value indicates a vehicle is
   * running late, while a negative value indicates a vehicle is running early.
   * 
   * @param offset in seconds
   */
  /*
  public void setPredictedArrivalOffset(int offset) {
    _hasPredictedArrivalOffset = true;
    _predictedArrivalOffset = offset;
  }
  */

  /**
   * The predicted arrival time offset is additive, which means a positive value
   * indicates a vehicle is running late, while a negative value indicates a
   * vehicle is running early.
   * 
   * @return the predicted arrival offset, in seconds
   */
  /*
  public int getPredictedArrivalOffset() {
    return _predictedArrivalOffset;
  }

  public boolean hasPredictedDepartureOffset() {
    return _hasPredictedDepartureOffset;
  }
  */

  /**
   * Set the predicted departure offset, in seconds. The predicted departure
   * time offset is additive, which means a positive value indicates a vehicle
   * is running late, while a negative value indicates a vehicle is running
   * early.
   * 
   * @param offset in seconds
   */
  /*
  public void setPredictedDepartureOffset(int offset) {
    _hasPredictedDepartureOffset = true;
    _predictedDepartureOffset = offset;
  }
  */

  /**
   * The predicted departure time offset is additive, which means a positive
   * value indicates a vehicle is running late, while a negative value indicates
   * a vehicle is running early.
   * 
   * @return the predicted departure offset, in seconds
   */
  /*
  public int getPredictedDepartureOffset() {
    return _predictedDepartureOffset;
  }

  public boolean hasDistanceFromStop() {
    return !Double.isNaN(_distanceFromStop);
  }

  public double getDistanceFromStop() {
    return _distanceFromStop;
  }

  public void setDistanceFromStop(double distanceFromStop) {
    _distanceFromStop = distanceFromStop;
  }
  
  public int getNumberOfStopsAway() {
    return _numberOfStopsAway;
  }
  
  public void setNumberOfStopsAway(int numberOfStopsAway) {
    _numberOfStopsAway = numberOfStopsAway;
  }
  */

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof StopTimeInstanceProxy))
      return false;
    StopTimeInstanceProxy other = (StopTimeInstanceProxy) obj;
    return _stopTime.equals(other._stopTime)
        && _serviceDate == other._serviceDate;
  }

  @Override
  public int hashCode() {
    return _stopTime.hashCode() + new Long(_serviceDate).hashCode();
  }

  @Override
  public String toString() {
    return "StopTimeInstanceProxy(trip=" + getTrip() + " service="
        + DAY_FORMAT.format(_serviceDate) + " arrival="
        + TIME_FORMAT.format(getArrivalTime()) + " departure="
        + TIME_FORMAT.format(getDepartureTime()) + ")";
  }
}
