package peer_to_peer.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import peer_to_peer.model.Level;
import peer_to_peer.model.Availability;

public class AvailabilityDao implements Dao<Availability> {
	
		
		private List<Availability> availabilities = new ArrayList<>();

		public AvailabilityDao(List<Availability> availabilities) {
			this.availabilities=availabilities;
		}
		public AvailabilityDao() {
		}
		public List<Availability> getAvailabilities() {
			return availabilities;
		}

		public void setAvailabilities(List<Availability> availabilities) {
			this.availabilities = availabilities;
		}

		@Override
		public Availability get(int index) {
			return availabilities.get(index);
		}

		@Override
		public List<Availability> getAll() {
			return availabilities;
		}

		@Override
		public void save(Availability availability) {
			availabilities.add(availability);
		}

		@Override
		public void update(int index, Availability availability) {
			availabilities.set(index, availability);
		}

		@Override
		public void delete(Availability availability) {
			availabilities.remove(availability);
			
		}
}
