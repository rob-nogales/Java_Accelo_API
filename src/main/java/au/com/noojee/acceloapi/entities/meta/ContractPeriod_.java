package au.com.noojee.acceloapi.entities.meta;

/** 
 *
 *          DO NOT MODIFY 
 *
 * This code is generated by au.com.noojee.acceloapi.entities.meta.FieldMetaDataGenerator
 *
 * The generator use @AcceloField annotations to determine what fields to include in the Meta data.
 *
 *          DO NOT MODIFY 
 *
 */
import java.time.LocalDate;

import au.com.noojee.acceloapi.entities.ContractPeriod;
import au.com.noojee.acceloapi.entities.generator.FilterField;


public class ContractPeriod_ 
{

	public static FilterField<ContractPeriod, String> allowance_type = new FilterField<>("allowance_type"); 
	public static FilterField<ContractPeriod, String> budget_type = new FilterField<>("budget_type"); 
	public static FilterField<ContractPeriod, Float> contract_budget = new FilterField<>("contract_budget"); 
	public static FilterField<ContractPeriod, Integer> contract_id = new FilterField<>("contract"); 
	public static FilterField<ContractPeriod, LocalDate> date_closed = new FilterField<>("date_closed"); 
	public static FilterField<ContractPeriod, LocalDate> date_commenced = new FilterField<>("date_commenced"); 
	public static FilterField<ContractPeriod, LocalDate> date_created = new FilterField<>("date_created"); 
	public static FilterField<ContractPeriod, LocalDate> date_expires = new FilterField<>("date_expires"); 
	public static FilterField<ContractPeriod, String> duration_type = new FilterField<>("duration_type"); 
	public static FilterField<ContractPeriod, Integer> id = new FilterField<>("id"); 
	public static FilterField<ContractPeriod, Integer> rate_id = new FilterField<>("rate"); 
	public static FilterField<ContractPeriod, String> rate_type = new FilterField<>("rate_type"); 
	public static FilterField<ContractPeriod, String> rollover = new FilterField<>("rollover"); 
	public static FilterField<ContractPeriod, Integer> service_item_id = new FilterField<>("service_item"); 
	public static FilterField<ContractPeriod, String> standing = new FilterField<>("standing"); 

}
