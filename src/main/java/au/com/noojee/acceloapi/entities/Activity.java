package au.com.noojee.acceloapi.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import javax.swing.text.html.HTML.Tag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javamoney.moneta.Money;

import au.com.noojee.acceloapi.Formatters;
import au.com.noojee.acceloapi.entities.meta.AcceloField;
import au.com.noojee.acceloapi.entities.meta.AcceloField.Type;

public class Activity extends AcceloEntity<Activity>
{

	static private Logger logger = LogManager.getLogger(Activity.class);
	

	public enum Medium
	{
		note, meeting, report, email, call, postal, fax, sms
	};

	public enum Visibility
	{
		all("all"), confidential("confidential"), _private("private");

		String name;

		Visibility(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			return this.name;

		}
	};

	@AcceloField
	private int id;
	private String subject;
	private String parent;
	
	@AcceloField
	private String parent_id;

	private String thread;
	private String thread_id;

	private String against_type;

	
	private int against_id;

	@AcceloField
	private int owner_id;
	
	@AcceloField
	private String owner_type;

	@AcceloField
	private Medium medium;
	
	private String body;
	
	@AcceloField
	private Visibility visiblity;

	private String details; // For meetings this is the location, for postals this is the address and for calls this is the number.

	private String standing; // The standing of the activity, may be one of “unapproved”, “approved”, “invoiced”, “locked”, or empty.
	private int invoice_id;
	private int contract_period_id;

	@AcceloField(Type.DATE)
	private long date_created;
	@AcceloField(Type.DATE)
	private long date_started;
	@AcceloField(Type.DATE)
	private long date_ended;
	@AcceloField(Type.DATE)
	private long date_logged;
	@AcceloField(Type.DATE)
	private long date_modified;

	private int billable; // amount of billable time logged for the activity in
							// seconds.
	private int nonbillable; // amount of non-billable seconds.

	@AcceloField
	private int staff;
	
	@AcceloField
	private int priority;
	
	@AcceloField
	private int _class;
	
	@AcceloField
	private int task;

	@AcceloField
	private int time_allocation; // The time allocation for the activity.
	private int rate; // id of the rate object
	private int rate_charged; // The rate at which the billable time was charged.

	List<Tag> tag; // A list of tags associated with the activity


	public void setId(int id)
	{
		this.id = id;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public void setBody(String body)
	{
		this.body = body;
	}

	public void setAgainstId(int id)
	{
		this.against_id = id;
	}

	public void setAgainst_type(String against_type)
	{
		this.against_type = against_type;
	}

	public void setOwnerId(int id)
	{
		this.owner_id = id;
	}

	public void setOwner_type(String owner_type)
	{
		this.owner_type = owner_type;
	}

	public void setMedium(Medium medium)
	{
		this.medium = medium;
	}

	public void setVisiblity(Visibility visiblity)
	{
		this.visiblity = visiblity;
	}

	public void setDetails(String details)
	{
		this.details = details;
	}

	public void setPriority(int priorityId)
	{
		this.priority = priorityId;
	}

	public void setClass(int ClassId)
	{
		this._class = ClassId;
	}

	public void setThreadId(String threadId)
	{
		this.thread_id = threadId;
	}

	public void setTaskId(int taskId)
	{
		this.task = taskId;
	}

	public void setParentId(String parentId)
	{
		this.parent_id = parentId;
	}

	public void setDateStarted(LocalDate dateStarted)
	{
		this.date_started = toDateAsLong(dateStarted);
	}

	public void setDateEnded(LocalDate dateEnded)
	{
		this.date_ended = toDateAsLong(dateEnded);
	}

	public void setDateCreated(LocalDate dateCreated)
	{
		this.date_created = toDateAsLong(dateCreated);
	}

	public void setDateModified(LocalDate dateModified)
	{
		this.date_modified = toDateAsLong(dateModified);
	}

	public void setStaffId(int staffId)
	{
		this.staff = staffId;
	}

	@Override
	public int getId()
	{
		return id;
	}

	public String getSubject()
	{
		return subject;
	}

	public String getParent()
	{
		return parent_id;
	}

	public String getThread()
	{
		return thread_id;
	}

	public int getAgainst()
	{
		return against_id;
	}

	public String getAgainstType()
	{
		return against_type;
	}

	public int getOwner()
	{
		return owner_id;
	}

	public Medium getMedium()
	{
		return medium;
	}

	public String getBody()
	{
		return body;
	}

	public String getDetails()
	{
		return details;
	}

	public LocalDate getDateCreated()
	{
		return toLocalDate(date_created);
	}

	public LocalDate getDateStarted()
	{
		return toLocalDate(date_started);
	}

	public LocalDate getDateEnded()
	{
		return toLocalDate(date_ended);
	}

	public LocalDate getDateModified()
	{
		return toLocalDate(date_modified);
	}

	public int getStaff()
	{
		return staff;
	}

	public int getPriority()
	{
		return priority;
	}

	public int getActivityClass()
	{
		return _class;
	}

	public int getTask()
	{
		return task;
	}

	public String getOwnerType()
	{
		return this.owner_type;
	}

	// public void setFrom(String fromAddr, String from_name)
	// {
	// this.fromAddr = fromAddr;
	// this.from_name = from_name;
	//
	// }
	//
	//
	// public void setTo(String toAddr, String to_name)
	// {
	// this.toAddr = toAddr;
	// this.to_name = to_name;
	// }
	//
	@Override
	public String toString()
	{
		return "Activity [id=" + id + ", subject=" + subject + ", parent=" + parent + ", parent_id=" + parent_id
				+ ", thread=" + thread + ", thread_id=" + thread_id + ", against_type=" + against_type + ", against_id="
				+ against_id + ", owner_id=" + owner_id + ", owner_type=" + owner_type + ", medium=" + medium
				+ ", body=" + body + ", visiblity=" + visiblity + ", details=" + details + ", date_created="
				+ date_created + ", date_started=" + date_started + ", date_ended=" + date_ended + ", date_logged="
				+ date_logged + ", date_modified=" + date_modified + ", billable=" + billable + ", nonbillable="
				+ nonbillable + ", staff=" + staff + ", priority=" + priority + ", _class=" + _class + ", task=" + task
				+ ", time_allocation=" + time_allocation + ", rate=" + rate + ", rate_charged=" + rate_charged
				+ ", tag=" + tag + "]";
	}

	public String getStanding()
	{
		return standing;
	}

	public void setStanding(String standing)
	{
		this.standing = standing;
	}

	public int getInvoiceId()
	{
		return invoice_id;
	}

	public void setInvoiceId(int invoiceId)
	{
		this.invoice_id = invoiceId;
	}

	public int getContractPeriodId()
	{
		return contract_period_id;
	}

	public void setContractPeriodId(int contractPeriodId)
	{
		this.contract_period_id = contractPeriodId;
	}

	public static Logger getLogger()
	{
		return logger;
	}

	public String getParentId()
	{
		return parent_id;
	}

	public String getThreadId()
	{
		return thread_id;
	}

	public int getAgainstId()
	{
		return against_id;
	}

	public int getOwnerId()
	{
		return owner_id;
	}

	public String getOwner_type()
	{
		return owner_type;
	}

	public Visibility getVisiblity()
	{
		return visiblity;
	}

	public long getDateLogged()
	{
		return date_logged;
	}

	public Duration getBillable()
	{
		return Duration.ofSeconds(billable);
	}

	public Duration getNonBillable()
	{
		return Duration.ofSeconds(nonbillable);
	}

	public Duration getTimeAllocation()
	{
		return Duration.ofSeconds(time_allocation);
	}

	public int getRateId()
	{
		return rate;
	}

	public Money getRateCharged()
	{
		return Money.of(rate_charged, Formatters.getCurrency());
	}

	public List<Tag> getTag()
	{
		return tag;
	}
	
	public boolean isApproved()
	{
		return standing != null && (standing.equals("approved") || standing.equals("invoiced"));
	}

	@Override
	public int compareTo(Activity o)
	{
		return this.getDateCreated().compareTo(o.getDateCreated());
	}

}