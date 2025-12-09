from setuptools import setup, find_packages

setup(
    name='apiverve_ringsizeconverter',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Ring Size Converter is a tool for converting ring sizes between US, UK, EU, JP, CH, and AU standards. It can also convert from diameter measurements in millimeters.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
