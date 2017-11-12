package com.java.que.example;

import static com.java.que.example.Category.PHONE;
import static com.java.que.example.Category.PRINTER;
import static com.java.que.example.Customer.JACK;
import static com.java.que.example.Customer.JILL;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

public class CategorisedHelpDesk {

	private final Queue<Enquiry> enquiries = new ArrayDeque<>();

	public void enquire(final Customer customer, final Category category) {
		enquiries.offer(new Enquiry(customer, category));
	}

	public void processAllEnquiries() {
		final String HAVE_YOU_TRIED_TURNING_IT_ON_AND_OFF_AGAIN = "Have you tried turning it on and off again?";
		while (!enquiries.isEmpty()) {
			final Enquiry enquiry = enquiries.remove();
			enquiry.getCustomer().reply(HAVE_YOU_TRIED_TURNING_IT_ON_AND_OFF_AGAIN);
		}
	}

	public void processPrinterEnquiry() {
		processEnquiry(enq -> enq.getCategory() == PRINTER, "Is it out of paper?");
	}

	public void processGeneralEnquiry() {
		processEnquiry(enq -> enq.getCategory() != PRINTER, "Have you tried turning it on and off again?");
	}

	private void processEnquiry(Predicate<Enquiry> predicate, final String message) {
		final Enquiry enquiry = enquiries.peek();
		if (enquiry != null && predicate.test(enquiry)) {
			enquiries.remove();
			enquiry.getCustomer().reply(message);
		} else {
			System.out.println("No work to do, let's have some coffee!");
		}
	}

	public static void main(String[] args) {

		CategorisedHelpDesk helpDesk = new CategorisedHelpDesk();
		helpDesk.enquire(JACK, PHONE);
		helpDesk.enquire(JILL, PRINTER);

		// helpDesk.processAllEnquiries();

		helpDesk.processPrinterEnquiry();
		helpDesk.processGeneralEnquiry();
		helpDesk.processPrinterEnquiry();
	}
}
