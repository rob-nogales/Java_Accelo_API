package au.com.noojee.acceloapi.entities;

import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import au.com.noojee.acceloapi.entities.meta.AcceloField;
import au.com.noojee.acceloapi.entities.meta.MetaSearchFields;
import au.com.noojee.acceloapi.filter.expressions.Expression;

public class Ticket extends AcceloEntity<Ticket>
{
	static Logger logger = LogManager.getLogger();

	// private Logger logger = LogManager.getLogger(Ticket.class);
	static public String PRIORITY_CRITICAL = "1";

	@SuppressWarnings("unused")
	private class Meta implements MetaSearchFields
	{
		@AcceloField
		private transient String contact_number;  // filters over phone, fax and mobile

	}

	@AcceloField
	private int id;
	private String title;
	@AcceloField
	private String custom_id;
	private String description;
	@AcceloField
	private int issue_type;
	
	@AcceloField
	private int affiliation; // The affiliated with this ticket which links
								// through to the contact
	private int against_id;
	private String against_type;
	private int company; // If against_type is company, then this holds the id of the company the ticket is
							// against.
	@AcceloField
	private String priority;
	@AcceloField(name="class")
	private int class_id; // note this currently doesn't work as the real field name is 'class' need to create a json mapper.
	
	@AcceloField
	private int resolution;
	@AcceloField
	private Status status; // Breaks our rules of using Ids but there is no
							// other way to get the status.
	
	@AcceloField
	private String referrer_type;
	@AcceloField
	private int referrer_id;
	
	@AcceloField
	private String standing;
	@AcceloField
	private int submitted_by;
	
	@AcceloField(AcceloField.Type.DATE)
	private long date_submitted;
	@AcceloField(AcceloField.Type.DATE)
	private long date_opened;
	
	private long date_resolved;
	@AcceloField(AcceloField.Type.DATE)
	private long date_closed;
	@AcceloField(AcceloField.Type.DATE)
	private long date_started;
	@AcceloField(AcceloField.Type.DATE)
	private long date_due;
	@AcceloField
	private int opened_by;			// staff member
	@AcceloField
	private int closed_by;			// staff member
	@AcceloField
	private int resolved_by;		// staff member
	private String object_budget;
	@AcceloField
	private int  assignee;			// staff member
	private int billable_seconds;
	private long date_last_interacted;
	private ArrayList<String> breadcrumbs;
	
	@AcceloField
	private int contract; // the contract id or 0 if this ticket is unassigned.
	private String resolution_detail;

	
	public int getAffiliation()
	{
		return affiliation;
	}

	/**
	 * Returns true of the ticket is currently open.
	 * 
	 * @return
	 */
	public boolean isOpen()
	{
		return getDateClosed() == null || getDateClosed().equals(Expression.DATEZERO)
				|| getDateClosed().isAfter(LocalDate.now()); // I don't think
																// this is
																// possible. but
																// still.
	}


	@Override
	public int getId()
	{
		return id;
	}
	
	public int getCompanyId()
	{
		return company;
	}

	public String getTitle()
	{
		return trim(title);
	}

	private String trim(String field)
	{
		return (field == null ? null : field.trim());
	}

	public String getCustomId()
	{
		return custom_id;
	}

	public String getDescription()
	{
		return trim(description);
	}

	public int getIssueType()
	{
		return issue_type;
	}

	public int getAgainstId()
	{
		return against_id;
	}

	public String getAgainstType()
	{
		return against_type;
	}


	public String getPriority()
	{
		return priority;
	}

	public int getClassId()
	{
		return class_id;
	}

	public int getResolution()
	{
		return resolution;
	}

	public Status getStatus()
	{
		return status;
	}

	public String getStanding()
	{
		return standing;
	}

	public int getSubmittedBy()
	{
		return submitted_by;
	}

	public LocalDate getDateSubmitted()
	{
		return toLocalDate(date_submitted);
	}

	public LocalDate getDateOpened()
	{
		return toLocalDate(date_opened);
	}

	public LocalDate getDateResolved()
	{
		return toLocalDate(date_resolved);
	}

	// Returns null if the ticket is still open.
	public LocalDate getDateClosed()
	{
		if (date_closed == 0)
			return null;

		return toLocalDate(date_closed);
	}

	public LocalDate getDateStarted()
	{
		return toLocalDate(date_started);
	}

	public LocalDate getDateDue()
	{
		return toLocalDate(date_due);
	}

	public int getClosedBy()
	{
		return closed_by;
	}

	public int getOpenedBy()
	{
		return opened_by;
	}

	public int getResolvedBy()
	{
		return resolved_by;
	}


	public String getObjectBudget()
	{
		return object_budget;
	}

	/**
	 * The staff id or -1 if no assigned engineer.
	 */
	public int getAssignee()
	{
		return assignee;
	}


	public LocalDate getDateLastInteracted()
	{
		return toLocalDate(date_last_interacted);
	}

	public ArrayList<String> getBreadcrumbs()
	{
		return breadcrumbs;
	}

	public int getContractId()
	{
		return contract;
	}

	public String getResolutionDetail()
	{
		return trim(resolution_detail);
	}
	
	/**
	 * Is the ticket Attached to a contract.
	 * @return
	 */
	public boolean isAttached()
	{
		return contract != 0;
	}


	public void setId(int id)
	{
		this.id = id;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setCustomId(String custom_id)
	{
		this.custom_id = custom_id;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setIssueType(int issueTypeId)
	{
		this.issue_type = issueTypeId;
	}

	public void setAgainstId(int against_id)
	{
		this.against_id = against_id;
	}

	public void setAgainstType(String against_type)
	{
		this.against_type = against_type;
	}

	public void setPriority(String priority)
	{
		this.priority = priority;
	}

	public void setClass(int class_id)
	{
		this.class_id = class_id;
	}

	public void setResolution(int resolution)
	{
		this.resolution = resolution;
	}

	public void setStanding(String standing)
	{
		this.standing = standing;
	}

	public void setSubmittedBy(int submitted_by)
	{
		this.submitted_by = submitted_by;
	}

	public void setDateSubmitted(long date_submitted)
	{
		this.date_submitted = date_submitted;
	}

	public void setDateOpened(long date_opened)
	{
		this.date_opened = date_opened;
	}

	public void setDateResolved(long date_resolved)
	{
		this.date_resolved = date_resolved;
	}

	public void setDateClosed(long date_closed)
	{
		this.date_closed = date_closed;
	}

	public void setDateStarted(long date_started)
	{
		this.date_started = date_started;
	}

	public void setDateDue(long date_due)
	{
		this.date_due = date_due;
	}

	public void setClosedBy(int closed_by)
	{
		this.closed_by = closed_by;
	}

	public void setOpenedBy(int opened_by)
	{
		this.opened_by = opened_by;
	}

	public void setResolvedBy(int resolved_by)
	{
		this.resolved_by = resolved_by;
	}

	public void setCompanyId(int companyId)
	{
		this.company = companyId;
	}

	public void setObjectBudget(String object_budget)
	{
		this.object_budget = object_budget;
	}

	public void setBillableSeconds(int billable_seconds)
	{
		this.billable_seconds = billable_seconds;
	}

	public void setDateLastInteracted(long date_last_interacted)
	{
		this.date_last_interacted = date_last_interacted;
	}

	public void setBreadcrumbs(ArrayList<String> breadcrumbs)
	{
		this.breadcrumbs = breadcrumbs;
	}

	public void setContractId(int contract)
	{
		this.contract = contract;
	}

	public void setResolution_detail(String resolution_detail)
	{
		this.resolution_detail = resolution_detail;
	}

	@Override
	public String toString()
	{
		return "Ticket [id=" + id + ", title=" + title + ", custom_id=" + custom_id + ", type=" + issue_type 
				+ ", against_id=" + against_id + ", against_type=" + against_type + ", priority=" + priority
				+ ", resolution=" + resolution + ", status=" + status + ", standing=" + standing + ", submitted_by="
				+ submitted_by + ", date_submitted=" + date_submitted + ", date_opened=" + date_opened
				+ ", date_resolved=" + date_resolved + ", date_closed=" + date_closed + ", date_started=" + date_started
				+ ", date_due=" + date_due + ", closed_by=" + closed_by + ", opened_by=" + opened_by + ", resolved_by="
				+ resolved_by + ", company=" + company + ", object_budget=" + object_budget + ", assignee=" + assignee
				+ ", billable_seconds=" + billable_seconds + ", date_last_interacted=" + date_last_interacted
				+ ", breadcrumbs=" + breadcrumbs + ", contract=" + contract + ", resolution_detail=" + resolution_detail
				+ ", description=" + description + "]";
	}

	@Override
	public int compareTo(Ticket o)
	{
		return this.getId() - o.getId();
	}


	

}