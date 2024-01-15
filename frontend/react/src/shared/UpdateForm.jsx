import React from 'react';
import { Formik, Form, useField } from 'formik';
import * as Yup from 'yup';
import { Alert, AlertIcon, Box, Button, FormLabel, Input, Select } from '@chakra-ui/react';
import { saveCustomer, updateCustomer } from '../services/client';
import { successNotification } from '../services/notification';
import { errorNotification } from '../services/notification';


const MyTextInput = ({ label, ...props }) => {
  // useField() returns [formik.getFieldProps(), formik.getFieldMeta()]
  // which we can spread on <input>. We can use field meta to show an error
  // message if the field is invalid and it has been touched (i.e. visited)
  const [field, meta] = useField(props);
  return (
    <Box>
      <FormLabel htmlFor={props.id || props.name}>{label}</FormLabel>
      <Input className="text-input" {...field} {...props} />
      {meta.touched && meta.error ? (
        <Alert className="error"><AlertIcon/>{meta.error}</Alert>
      ) : null}
    </Box>
  );
};


const MySelect = ({ label, ...props }) => {
  const [field, meta] = useField(props);
  return (
    <Box>
      <FormLabel htmlFor={props.id || props.name}>{label}</FormLabel>
      <Select {...field} {...props} />
      {meta.touched && meta.error ? (
         <Alert className="error"><AlertIcon/>{meta.error}</Alert>
      ) : null}
    </Box>
  );
};

// And now we can use these
const UpdateForm = ({id,name,email,age,gender}) => {
  return (
    <>
     
      <Formik
        initialValues={{
          name: name,
          email: email,
          age :age,
          gender: gender,
        }}
        validationSchema={Yup.object({
          name: Yup.string()
            .max(15, 'Must be 15 characters or less')
            .required('Required'),
          email: Yup.string()
            .email('Invalid email address')
            .required('Required'),
         age: Yup.number().min(16,'minimum age is 16').required('Require'),
          gender: Yup.string()
            .oneOf(
              ['MALE', 'FEMALE'],
              'Invalid gender'
            )
            .required('Required'),
        })}
        onSubmit={(customer, { setSubmitting }) => {
         setSubmitting(true)
         updateCustomer(id,customer).then(res=>{
          console.log(res)
            successNotification("customer updated",`${customer.name} was successfully added`)
            window.location.reload();

         }).catch( err=>{console.log(err)
        errorNotification(err.code ,err.response)
        
        }).finally(setSubmitting(false))
        }}
      >
{({isValid,isSubmitting})=>(
        <Form>
          <MyTextInput
            label="Name"
            name="name"
            type="text"
            placeholder="Jane"
          />


          <MyTextInput
            label="Email Address"
            name="email"
            type="email"
            placeholder="jane@formik.com"
          />
          <MyTextInput
            label="Age"
            name="age"
            type="number"
            placeholder="Age"
          />

          <MySelect label="gender" name="gender">
            <option value="">Select a gender</option>
            <option value="MALE">MALE</option>
            <option value="FEMALE">FEMALE</option>
          </MySelect>

       

          <Button disabled ={!isValid||isSubmitting} mt={'30px'} colorScheme='blue' type="submit">Submit</Button>
        </Form>)}

      </Formik>
    </>
  );
};
export default UpdateForm;