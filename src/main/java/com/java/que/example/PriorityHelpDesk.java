package com.java.que.example;

import static com.java.que.example.Customer.JACK;
import static com.java.que.example.Customer.JILL;
import static com.java.que.example.Customer.MARY;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityHelpDesk {

	private final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {

		@Override
		public int compare(Enquiry o1, Enquiry o2) {
			return o1.getCategory().compareTo(o2.getCategory());
		}
	};

	private final Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

	public void enquire(final Customer customer, final Category category) {
		enquiries.offer(new Enquiry(customer, category));
	}

	public void processAllEnquiries() {
		Enquiry enquiry;
		while ((enquiry = enquiries.poll()) != null) {
			enquiry.getCustomer().reply("Have you tried turning it on and off again?");
		}
	}

	public static void main(String[] args) {

		PriorityHelpDesk helpDesk = new PriorityHelpDesk();
		helpDesk.enquire(JACK, Category.PHONE);
		helpDesk.enquire(JILL, Category.PRINTER);
		helpDesk.enquire(MARY, Category.COMPUTER);

		helpDesk.processAllEnquiries();
	}
}
