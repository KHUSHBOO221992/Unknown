/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.List;

/**
 *
 * @author macstudent
 */
interface IFlightSegmentReservation{
    
    String[] FlightSegmentReservationTypes = {FlightSegmentReservationEnum.BUSINESS.toString(),FlightSegmentReservationEnum.ECONOMIC.toString() };
    
     void computePrice(List<Integer> lstSeatsReservedByPassenger);
}
