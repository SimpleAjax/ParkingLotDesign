# ParkingLotLLD
#### ParkingLot low level design


### Problem Statement:

	Design a car parking system that could support the following features: 
		1. Customers are given a ticket that they can use to redeem to get their car back. 
		2. Parking spots come in various sizes.
		3. Cars may vary in sizes too according to their model (suv, sedan, hatchback etc.)
		4. A car can be parked in a parking spot equal to or bigger in size (ex hatchback can be parked in hatchback as well as sedan parking)

 

### Self imposed requirements and assumptions:
	Requirements:
	  a. All cars coming in goes out on the same day. 
	  b. Building where it's being parked can have multiple floors, sections
	  c. Showing the position of the incoming car, where to park it. 
	  d. 3 filling strategies:
	    i. Parking lot is filled from equal to bigger size each floor/section
	    ii. Parking lot is filled from equal to bigger size each building.
	    iii. Parking lot is filled from equal to bigger size upto a distance from a gate
	  e. Can have multiple entry/exit gates. 
	  f. Cost Calculation Strategy 
  
  
  

### Classes:
	User, Admin, Operator, Technician 
	Gate (entry, exit), 
	Ticket, Vehicle (bike, car, truck), ParkingBuilding, Section
	Lot (xxl, xl, l), VehicleToLotSizeMapping 
	ParkingStrategy ( Floor, Building, DoorDistance)
	TicketGenerator
	CostCalculationStrategy
	



### Class details:
	1. User: name, address, join date, last login time
	2. Admin: permissions, add/remove/updateOperator/Technicine, 
	3. Operator/Technicine: attandence..
	4. Gate: gateNo, Section, GateTypeEnum (entry/exit), TicketGenerator 
	5. TicketGenerator: Subsections decorator for ticketId generation, 
	6. Vehicle: vehicle no, vehicleTypeEnum
	7. vehicleTypeEnum: ParkingSizeEnum, typeName
	8. ParkingSizeEnum: 
	9. ParkingBuilding: name, location, List<Section>
	10. Section: parentSection, List<Section> subSections
	11. Lot extends Section: parkingSizeEnum, parentSection
  




![image](https://user-images.githubusercontent.com/88624315/151290109-70571c44-6bd8-4fa8-8849-f8a8c539534e.png)



