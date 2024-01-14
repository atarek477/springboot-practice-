import axios from 'axios';
export const getCustomer =async()=>{
try{

return await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/v1/customer`)

}catch(e){throw e}


}


export const saveCustomer =async(customer)=>{
    try{
    
    return await axios.post(`${import.meta.env.VITE_API_BASE_URL}/api/v1/customer/save`,customer)
    
    }catch(e){throw e}
    
    
    }